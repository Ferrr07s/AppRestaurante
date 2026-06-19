package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Mesa;
import pe.senati.service.MesaService;

@RestController
@RequestMapping("/mesa")
public class MesaRestController {

    @Autowired
    private MesaService mesaService;

    public MesaRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Mesa> mesas = mesaService.findAll();
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Mesa mesa) {
        mesaService.insert(mesa);
        return new ResponseEntity<>("¡Mesa registrada!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{mesa_id}")
    public ResponseEntity<?> editar_PUT(@RequestBody Mesa mesa, @PathVariable Integer mesa_id) {

        Mesa mesaDb = mesaService.findbyId(mesa_id);

        if (mesaDb != null) {
        	//campos simples
            mesaDb.setNumero(mesa.getNumero());
            mesaDb.setCapacidad(mesa.getCapacidad());
            mesaDb.setEstado(mesa.getEstado());
            //Relaciones 
            mesaDb.setReserva(mesa.getReserva());
            mesaDb.setPedidos(mesa.getPedidos());  

            mesaService.update(mesaDb);
            return new ResponseEntity<>("¡Mesa actualizada!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Mesa no encontrada!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{mesa_id}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer mesa_id) {

        Mesa mesaDb = mesaService.findbyId(mesa_id);

        if (mesaDb != null) {
            mesaService.delete(mesa_id);
            return new ResponseEntity<>("¡Mesa eliminada!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Mesa no encontrada!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{mesa_id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer mesa_id) {

        Mesa mesaDb = mesaService.findbyId(mesa_id);

        if (mesaDb != null) {
            return new ResponseEntity<>(mesaDb, HttpStatus.FOUND);
        }

        return new ResponseEntity<>("Mesa no encontrada!", HttpStatus.NOT_FOUND);
    }
}