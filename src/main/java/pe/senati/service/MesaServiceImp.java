package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Mesa;
import pe.senati.repository.MesaRepository;

@Service
public class MesaServiceImp implements MesaService {

	@Autowired
	private MesaRepository repository;

	public MesaServiceImp() {}

	@Override
	@Transactional
	public void insert(Mesa mesa) {
		repository.save(mesa);
	}

	@Override
	@Transactional
	public void update(Mesa mesa) {
		repository.save(mesa);
	}

	@Override
	@Transactional
	public void delete(Integer mesa_id) {
		repository.deleteById(mesa_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Mesa findbyId(Integer mesa_id) {
		return repository.findById(mesa_id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Mesa> findAll() {
		return repository.findAll();
	}
}