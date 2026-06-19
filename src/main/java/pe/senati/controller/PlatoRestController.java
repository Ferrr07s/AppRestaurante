package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Plato;
import pe.senati.service.PlatoService;

@RestController
@RequestMapping("/plato")
public class PlatoRestController {

    @Autowired
    private PlatoService platoService;

    public PlatoRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Plato> platos = platoService.findAll();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Plato plato) {
        platoService.insert(plato);
        return new ResponseEntity<>("¡Plato registrado!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{plato_id}")
    public ResponseEntity<?> editar_PUT(@RequestBody Plato plato, @PathVariable Integer plato_id) {

        Plato platoDb = platoService.findbyId(plato_id);

        if (platoDb != null) {

            //Campos simples
            platoDb.setNombre(plato.getNombre());
            platoDb.setPrecio(plato.getPrecio());
            platoDb.setEstado(plato.getEstado());
            // Relacion
            platoDb.setPedidos(plato.getPedidos());

            platoService.update(platoDb);
            return new ResponseEntity<>("¡Plato actualizado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Plato no encontrado!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{plato_id}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer plato_id) {

        Plato platoDb = platoService.findbyId(plato_id);

        if (platoDb != null) {
            platoService.delete(plato_id);
            return new ResponseEntity<>("¡Plato eliminado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Plato no encontrado!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{plato_id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer plato_id) {

        Plato platoDb = platoService.findbyId(plato_id);

        if (platoDb != null) {
            return new ResponseEntity<>(platoDb, HttpStatus.FOUND);
        }

        return new ResponseEntity<>("Plato no encontrado!", HttpStatus.NOT_FOUND);
    }
}