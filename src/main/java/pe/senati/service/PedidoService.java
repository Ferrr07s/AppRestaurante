package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Pedido;

public interface PedidoService {
	public abstract void insert(Pedido pedido);
	public abstract void update(Pedido pedido);
	public abstract void delete(Integer pedido_id);
	public abstract Pedido findbyId(Integer pedido_id);
	public abstract Collection<Pedido> findAll();
}