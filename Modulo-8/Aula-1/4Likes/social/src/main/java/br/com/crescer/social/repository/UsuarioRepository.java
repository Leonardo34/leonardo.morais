package br.com.crescer.social.repository;

import br.com.crescer.social.models.Usuario;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
