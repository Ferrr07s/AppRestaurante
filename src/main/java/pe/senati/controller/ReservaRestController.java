package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Reserva;
import pe.senati.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaRestController {

    @Autowired
    private ReservaService reservaService;

    public ReservaRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Reserva> reservas = reservaService.findAll();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Reserva reserva) {
        reservaService.insert(reserva);
        return new ResponseEntity<>("¡Reserva registrada!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{reserva_id}")
    public ResponseEntity<?> editar_PUT(@RequestBody Reserva reserva, @PathVariable Integer reserva_id) {

        Reserva reservaDb = reservaService.findbyId(reserva_id);

        if (reservaDb != null) {
            //Actualizamos campos simples
            reservaDb.setFecha(reserva.getFecha());
            reservaDb.setHora(reserva.getHora());
            reservaDb.setAsistentes(reserva.getAsistentes());
            reservaDb.setEstado(reserva.getEstado());
            //campos relaciones
            reservaDb.setCliente(reserva.getCliente()); 
            reservaDb.setMesa(reserva.getMesa());       

            reservaService.update(reservaDb);
            return new ResponseEntity<>("¡Reserva actualizada!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Reserva no encontrada!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{reserva_id}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer reserva_id) {

        Reserva reservaDb = reservaService.findbyId(reserva_id);

        if (reservaDb != null) {
            reservaService.delete(reserva_id);
            return new ResponseEntity<>("¡Reserva eliminada!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Reserva no encontrada!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{reserva_id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer reserva_id) {

        Reserva reservaDb = reservaService.findbyId(reserva_id);

        if (reservaDb != null) {
            return new ResponseEntity<>(reservaDb, HttpStatus.FOUND);
        }

        return new ResponseEntity<>("Reserva no encontrada!", HttpStatus.NOT_FOUND);
    }
}