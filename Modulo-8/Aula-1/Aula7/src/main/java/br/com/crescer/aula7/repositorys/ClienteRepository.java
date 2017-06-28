package br.com.crescer.aula7.repositorys;

import br.com.crescer.aula7.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
