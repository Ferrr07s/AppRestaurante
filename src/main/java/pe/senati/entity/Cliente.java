package pe.senati.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="clientes")
public class Cliente 
{
    //propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cliente_id;
	@Column
    private String nombre;
	@Column
	private String telefono;
	@Column(unique=true,nullable=false) //Clave unica de esta entidad
	private String correo;
	@Column
	private Boolean reservado;
	@DateTimeFormat(pattern ="yyyy-MM--dd",iso = ISO.DATE)
	private	LocalDate fechaReserva;
	
	//El que recibe la fk.
	//Relacion One to One
    @OneToOne(mappedBy = "cliente")
    private Reserva reserva;
     			//algo clave que no debo olvidarme AGREGAR SUS GETTER Y SETTER DE LA COLUMNA RELACION.
     // constructor vacio
    public Cliente() {}


	public Cliente(Integer cliente_id, String nombre, String telefono, String correo, Boolean reservado,
			LocalDate fechaReserva) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.reservado = reservado;
		this.fechaReserva = fechaReserva;
	}


	public Integer getCliente_id() {
		return cliente_id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public Boolean getReservado() {
		return reservado;
	}


	public LocalDate getFechaReserva() {
		return fechaReserva;
	}


	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}


	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

    
	
	
  
    

}