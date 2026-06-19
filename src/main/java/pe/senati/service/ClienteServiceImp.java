package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pe.senati.entity.Cliente;
import pe.senati.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	//Inyecto mi depedencia.
	@Autowired
	private ClienteRepository repository;
	
	//metodo construct vacio
	public ClienteServiceImp() {}
	
	@Override
	@Transactional
	public void insert(Cliente cliente) {
		
		repository.save(cliente);
		
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		
		repository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer cliente_id) {
		repository.deleteById(cliente_id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findbyId(Integer cliente_id) {
		
		return repository.findById(cliente_id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cliente> findAll() {
		
		return repository.findAll();
	}
	
	}
