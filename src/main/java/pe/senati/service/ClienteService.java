package pe.senati.service;

import java.util.Collection;


import pe.senati.entity.Cliente;

public interface ClienteService {
	public abstract void insert(Cliente cliente);
	public abstract void update(Cliente cliente);
	public abstract void delete(Integer cliente_id);
	public abstract Cliente findbyId(Integer cliente_id);
	public abstract Collection<Cliente> findAll();
}
