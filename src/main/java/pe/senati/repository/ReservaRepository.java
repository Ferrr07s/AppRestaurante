package pe.senati.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.senati.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
