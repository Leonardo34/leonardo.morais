package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Genero;
import br.com.crescer.aula7.repositorys.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {   
    
    @Autowired
    private GeneroRepository repositorio;
    
    public List<Genero> list() {
        return (List) repositorio.findAll();
    }
    
    public Genero addGenero(Genero genero) {
        return repositorio.save(genero);
    }
    
    public void remove(Genero genero) {
        repositorio.delete(genero);
    }
    
    public Genero getGeneroById(Long id) {
        return repositorio.findOne(id);
    }
}
