package br.com.crescer.aula7.repositorys;

import br.com.crescer.aula7.models.Genero;
import org.springframework.data.repository.CrudRepository;

public interface GeneroRepository extends CrudRepository<Genero, Long> {
    
}
