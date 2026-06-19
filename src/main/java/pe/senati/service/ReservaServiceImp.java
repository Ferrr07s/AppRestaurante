package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Reserva;
import pe.senati.repository.ReservaRepository;

@Service
public class ReservaServiceImp implements ReservaService {

	@Autowired
	private ReservaRepository repository;

	public ReservaServiceImp() {}

	@Override
	@Transactional
	public void insert(Reserva reserva) {
		repository.save(reserva);
	}

	@Override
	@Transactional
	public void update(Reserva reserva) {
		repository.save(reserva);
	}

	@Override
	@Transactional
	public void delete(Integer reserva_id) {
		repository.deleteById(reserva_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findbyId(Integer reserva_id) {
		return repository.findById(reserva_id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Reserva> findAll() {
		return repository.findAll();
	}
}