package pe.senati.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mesas")
public class Mesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mesa_id;
	@Column(unique= true, nullable= false) //clave unica
	private Integer numero;
	@Column
	private Integer capacidad;
	@Column
	private Boolean estado;
	
	//Relacion 1:1, mesa con reserva. (el que recibe).
	//Una mesa puede tener una reserva asociada.
	@OneToOne(mappedBy = "mesa")
	private Reserva reserva; 
		//algo clave que no debo olvidarme AGREGAR SUS GETTER Y SETTER DE LA COLUMNA RELACION.
	
	//Relacion Uno a muchos. Ya que en una mesa se realizan MUCHOS pedidos.
	@OneToMany(mappedBy = "mesa")
	private Set<Pedido> pedidos= new HashSet<>(); //En esta lista se almacena y recorre los pedidos de la mesa.
	
	                	
	//Constructor base.
	public Mesa() {	}


	public Mesa(Integer mesa_id, Integer numero, Integer capacidad, Boolean estado, Reserva reserva,
			Set<Pedido> pedidos) {
		super();
		this.mesa_id = mesa_id;
		this.numero = numero;
		this.capacidad = capacidad;
		this.estado = estado;
		this.reserva = reserva;
		this.pedidos = pedidos;
	}


	public Integer getMesa_id() {
		return mesa_id;
	}


	public Integer getNumero() {
		return numero;
	}


	public Integer getCapacidad() {
		return capacidad;
	}


	public Boolean getEstado() {
		return estado;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public Set<Pedido> getPedidos() {
		return pedidos;
	}


	public void setMesa_id(Integer mesa_id) {
		this.mesa_id = mesa_id;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	

		
}
