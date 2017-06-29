package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Cliente;
import br.com.crescer.aula7.repositorys.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepositorio;
    
    public List<Cliente> list() {
        return (List) clienteRepositorio.findAll();
    }
    
    public Cliente addCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }
    
    public void remove(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
    
    public Cliente getClienteById(Long id) {
        return clienteRepositorio.findOne(id);
    }
}