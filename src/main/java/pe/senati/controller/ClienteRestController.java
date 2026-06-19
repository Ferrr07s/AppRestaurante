package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Cliente;
import pe.senati.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    public ClienteRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Cliente> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente) {
        clienteService.insert(cliente);
        return new ResponseEntity<>("¡Cliente registrado!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{cliente_id}")
    public ResponseEntity<?> editar_PUT(@RequestBody Cliente cliente, @PathVariable Integer cliente_id) {

        Cliente clienteDb = clienteService.findbyId(cliente_id);

        if (clienteDb != null) {
        	//campos
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setTelefono(cliente.getTelefono());
            clienteDb.setCorreo(cliente.getCorreo());
            clienteDb.setReservado(cliente.getReservado());
            clienteDb.setFechaReserva(cliente.getFechaReserva());

            clienteService.update(clienteDb);
            return new ResponseEntity<>("¡Cliente actualizado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente no encontrado!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{cliente_id}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer cliente_id) {

        Cliente clienteDb = clienteService.findbyId(cliente_id);

        if (clienteDb != null) {
            clienteService.delete(cliente_id);
            return new ResponseEntity<>("¡Cliente eliminado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente no encontrado!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{cliente_id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer cliente_id) {

        Cliente clienteDb = clienteService.findbyId(cliente_id);

        if (clienteDb != null) {
            return new ResponseEntity<>(clienteDb, HttpStatus.FOUND);
        }

        return new ResponseEntity<>("Cliente no encontrado!", HttpStatus.NOT_FOUND);
    }
    
    
    
}