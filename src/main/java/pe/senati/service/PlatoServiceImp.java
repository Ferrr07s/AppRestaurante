package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Plato;
import pe.senati.repository.PlatoRepository;

@Service
public class PlatoServiceImp implements PlatoService {

	@Autowired
	private PlatoRepository repository;

	public PlatoServiceImp() {}

	@Override
	@Transactional
	public void insert(Plato plato) {
		repository.save(plato);
	}

	@Override
	@Transactional
	public void update(Plato plato) {
		repository.save(plato);
	}

	@Override
	@Transactional
	public void delete(Integer plato_id) {
		repository.deleteById(plato_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Plato findbyId(Integer plato_id) {
		return repository.findById(plato_id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Plato> findAll() {
		return repository.findAll();
	}
}