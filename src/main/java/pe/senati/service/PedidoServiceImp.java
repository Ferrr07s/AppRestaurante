package pe.senati.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.senati.entity.Pedido;
import pe.senati.repository.PedidoRepository;

@Service
public class PedidoServiceImp implements PedidoService {

	@Autowired
	private PedidoRepository repository;

	public PedidoServiceImp() {}

	@Override
	@Transactional
	public void insert(Pedido pedido) {
		repository.save(pedido);
	}

	@Override
	@Transactional
	public void update(Pedido pedido) {
		repository.save(pedido);
	}

	@Override
	@Transactional
	public void delete(Integer pedido_id) {
		repository.deleteById(pedido_id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findbyId(Integer pedido_id) {
		return repository.findById(pedido_id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pedido> findAll() {
		return repository.findAll();
	}
}