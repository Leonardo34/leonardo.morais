package br.com.crescer.social.repository;

import br.com.crescer.social.models.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    
}
