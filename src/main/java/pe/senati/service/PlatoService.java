package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Plato;

public interface PlatoService {
	public abstract void insert(Plato plato);
	public abstract void update(Plato plato);
	public abstract void delete(Integer plato_id);
	public abstract Plato findbyId(Integer plato_id);
	public abstract Collection<Plato> findAll();
}