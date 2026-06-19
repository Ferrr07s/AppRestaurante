package pe.senati.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//Estableciendo las anotaciones para convertir a tabla en MySQL.
@Entity
@Table(name= "platos")
public class Plato {
	//Colocando la primera columna como un ID principal y autoincrementable.
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer plato_id;
	@Column(unique=true,nullable=false)
	private String nombre;
	@Column
	private Double precio;
	@Column
	private Boolean estado;
	
	
	//Relacion MUCHOS A MUCHOS (LADO VISCEVERSA).
	@ManyToMany(mappedBy = "platos")
	private Set<Pedido> pedidos= new HashSet<>(); //pedidos donde aparece el PLATO
	
	//algo clave que no debo olvidarme AGREGAR SUS GETTER Y SETTER DE LA COLUMNA RELACION.
	
	
	//constructor base
	public Plato() {}

	public Plato(Integer plato_id, String nombre, Double precio, Boolean estado) {
		super();
		this.plato_id = plato_id;
		this.nombre = nombre;
		this.precio = precio;
		this.estado = estado;
	}

	public Integer getPlato_id() {
		return plato_id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setPlato_id(Integer plato_id) {
		this.plato_id = plato_id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	
	
}
