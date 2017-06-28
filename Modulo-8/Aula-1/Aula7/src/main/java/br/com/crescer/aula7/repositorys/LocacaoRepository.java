package br.com.crescer.aula7.repositorys;

import br.com.crescer.aula7.models.Locacao;
import org.springframework.data.repository.CrudRepository;

public interface LocacaoRepository extends CrudRepository<Locacao, Long> {
    
}
