package br.edu.ifg.numbers.clienteapi.controller;

import br.edu.ifg.numbers.clienteapi.model.Cliente;
import br.edu.ifg.numbers.clienteapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente) {
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
}

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {
    if (!clienteService.findById(id).isPresent()) {
        return ResponseEntity.notFound().build();
    }
    cliente.setId(id);
    return ResponseEntity.ok(clienteService.save(cliente));
}


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        if (!clienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
        if (!clienteService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
