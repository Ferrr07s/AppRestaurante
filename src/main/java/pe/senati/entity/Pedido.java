package pe.senati.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pedido_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso = ISO.DATE)
	private LocalDate fecha;
	@Column
	private Double total;
	@Column
	private Boolean estado;
	
	// Relacion Muchos a Uno (visceversa) ya que muchos pedidos dependen de una mesa.
	@ManyToOne
	@JoinColumn(name="mesa_id",nullable=false) //Mi fk porque Pedido depende de Mesa.
	private Mesa mesa;
	//algo clave que no debo olvidarme AGREGAR SUS GETTER Y SETTER DE LA COLUMNA RELACION.
	
	// RELACION MUCHOS A MUCHOS: PEDIDO CON PLATO.
	@ManyToMany
	@JoinTable( 		//La tabla intermedia de esta relacion.
			name="pedidos_platos",
			joinColumns = @JoinColumn(name="pedido_id"), //fk hacia pedido
			inverseJoinColumns = @JoinColumn(name="plato_id") //fkhacia plato			
			)
	private Set<Plato> platos = new HashSet<>();  //Lista de platos del pedido.
	
	//constructor base.
	public Pedido() {}



	public Pedido(Integer pedido_id, LocalDate fecha, Double total, Boolean estado) {
		super();
		this.pedido_id = pedido_id;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}



	public Integer getPedido_id() {
		return pedido_id;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public Double getTotal() {
		return total;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public Mesa getMesa() {
		return mesa;
	}



	public Set<Plato> getPlatos() {
		return platos;
	}



	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}



	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}
	
	
	
	

}
