package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Mesa;

public interface MesaService {
	public abstract void insert(Mesa mesa);
	public abstract void update(Mesa mesa);
	public abstract void delete(Integer mesa_id);
	public abstract Mesa findbyId(Integer mesa_id);
	public abstract Collection<Mesa> findAll();
}