package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.senati.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}