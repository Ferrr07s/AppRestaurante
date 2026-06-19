package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.senati.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
}
