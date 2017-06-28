package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.models.Genero;
import br.com.crescer.aula7.services.GeneroService;
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
public class GeneroController {
    
    @Autowired
    private GeneroService service;
    
    @GetMapping(value = "/genero")
    public List<Genero> listGeneros() {
        return service.list();
    }
    
    @GetMapping(value = "/genero/{id}")
    public Genero getGenero(@PathVariable Long id) {
        return service.getGeneroById(id);
    }
    
    @PostMapping(value = "/genero")
    public void addGenero(@RequestBody Genero genero) {
        service.addGenero(genero);
    }
    
    @DeleteMapping(value = "/genero")
    public void removeGenero(@RequestBody Genero genero) {
        service.remove(genero);
    }
    
    @PutMapping(value = "/genero")
    public void updateGenero(@RequestBody Genero genero) {
        service.addGenero(genero);
    }
}
