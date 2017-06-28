package br.com.crescer.aula7.repositorys;

import br.com.crescer.aula7.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
}
