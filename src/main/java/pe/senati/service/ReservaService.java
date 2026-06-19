package pe.senati.service;

import java.util.Collection;
import pe.senati.entity.Reserva;

public interface ReservaService {
	public abstract void insert(Reserva reserva);
	public abstract void update(Reserva reserva);
	public abstract void delete(Integer reserva_id);
	public abstract Reserva findbyId(Integer reserva_id);
	public abstract Collection<Reserva> findAll();
}