package pe.senati.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="reservas")
public class Reserva {
	
	//Atributos
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer reserva_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso = ISO.DATE)
	private LocalDate fecha;
	@Column
	private String hora;
	@Column
	private Integer asistentes;
	@Column
	private Boolean estado;
	
	//MI ENTIDAD RESERVA SERA QUIEN TENGA LA FK DUEÑA PORQUE DEPENDE DE CLIENTE.
	//RELACION ONE TO ONE.
	@OneToOne
	@JoinColumn(name="cliente_id", unique=true, nullable=false)
	private Cliente cliente;	
		//algo clave que no debo olvidarme AGREGAR SUS GETTER Y SETTER DE LA COLUMNA RELACION.
	
	//Reserva como dueño para relacion 1:1 con Mesa.
	@OneToOne //una reserva usa una sola mesa.
	@JoinColumn(name="mesa_id", unique=true, nullable=false)
	private Mesa mesa;
		
	//Constructor base.
	public Reserva() {}

	public Reserva(Integer reserva_id, LocalDate fecha, String hora, Integer asistentes, Boolean estado) {
		super();
		this.reserva_id = reserva_id;
		this.fecha = fecha;
		this.hora = hora;
		this.asistentes = asistentes;
		this.estado = estado;
	}

	public Integer getReserva_id() {
		return reserva_id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public Integer getAsistentes() {
		return asistentes;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setReserva_id(Integer reserva_id) {
		this.reserva_id = reserva_id;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setAsistentes(Integer asistentes) {
		this.asistentes = asistentes;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	
	
	
	
}
