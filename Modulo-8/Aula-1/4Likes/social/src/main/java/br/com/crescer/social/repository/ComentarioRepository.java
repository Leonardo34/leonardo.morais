package br.com.crescer.social.repository;

import br.com.crescer.social.models.Comentario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ComentarioRepository extends PagingAndSortingRepository<Comentario, Long> {
    
}
