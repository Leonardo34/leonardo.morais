package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Genero;
import br.com.crescer.aula7.repositorys.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {   
    
    @Autowired
    private GeneroRepository generoRepositorio;
    
    public List<Genero> list() {
        return (List) generoRepositorio.findAll();
    }
    
    public Genero addGenero(Genero genero) {
        return generoRepositorio.save(genero);
    }
    
    public void remove(Genero genero) {
        generoRepositorio.delete(genero);
    }
    
    public Genero getGeneroById(Long id) {
        return generoRepositorio.findOne(id);
    }
}
