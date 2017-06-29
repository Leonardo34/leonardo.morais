package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.models.Funcionario;
import br.com.crescer.aula7.services.FuncionarioService;
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
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping(value = "/funcionario")
    public List<Funcionario> listFuncionarios() {
        return funcionarioService.list();
    }
    
    @GetMapping(value = "/funcionario/{id}")
    public Funcionario getFuncionario(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }
    
    @PostMapping(value = "/funcionario")
    public void addFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.addFuncionario(funcionario);
    }
    
    @DeleteMapping(value = "/funcionario/{id}")
    public void removeFuncionario(@PathVariable Long id) {
        funcionarioService.remove(funcionarioService.getFuncionarioById(id));
    }
    
    @PutMapping(value = "/funcionario")
    public void updateFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.addFuncionario(funcionario);
    }
}
