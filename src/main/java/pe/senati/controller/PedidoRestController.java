package pe.senati.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.senati.entity.Pedido;
import pe.senati.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;

    public PedidoRestController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET() {
        Collection<Pedido> pedidos = pedidoService.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Pedido pedido) {
        pedidoService.insert(pedido);
        return new ResponseEntity<>("¡Pedido registrado!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{pedido_id}")
    public ResponseEntity<?> editar_PUT(@RequestBody Pedido pedido, @PathVariable Integer pedido_id) {

        Pedido pedidoDb = pedidoService.findbyId(pedido_id);

        if (pedidoDb != null) {
        	//campos simples
            pedidoDb.setFecha(pedido.getFecha());
            pedidoDb.setEstado(pedido.getEstado());
            pedidoDb.setTotal(pedido.getTotal());
            //Relaciones
            pedidoDb.setMesa(pedido.getMesa());
            pedidoDb.setPlatos(pedido.getPlatos());

            pedidoService.update(pedidoDb);
            return new ResponseEntity<>("¡Pedido actualizado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Pedido no encontrado!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{pedido_id}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer pedido_id) {

        Pedido pedidoDb = pedidoService.findbyId(pedido_id);

        if (pedidoDb != null) {
            pedidoService.delete(pedido_id);
            return new ResponseEntity<>("¡Pedido eliminado!", HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Pedido no encontrado!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{pedido_id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer pedido_id) {

        Pedido pedidoDb = pedidoService.findbyId(pedido_id);

        if (pedidoDb != null) {
            return new ResponseEntity<>(pedidoDb, HttpStatus.FOUND);
        }

        return new ResponseEntity<>("Pedido no encontrado!", HttpStatus.NOT_FOUND);
    }
}