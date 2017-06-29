package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.models.Cliente;
import br.com.crescer.aula7.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;   
    
    @GetMapping(value = "/cliente")
    public List<Cliente> listClientes() {
        return clienteService.list();
    }
    
    @GetMapping(value = "/cliente/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }
    
    @PostMapping(value = "/cliente")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }
    
    @DeleteMapping(value = "/cliente/{id}")
    public void removeCliente(@PathVariable Long id) {
        clienteService.remove(clienteService.getClienteById(id));
    }
    
    @PutMapping(value = "/cliente")
    public void updateCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }
}