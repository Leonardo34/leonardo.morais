package br.com.crescer.social.repository;

import br.com.crescer.social.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
