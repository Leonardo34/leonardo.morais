package br.com.crescer.social.repository;

import br.com.crescer.social.models.Post;
import br.com.crescer.social.models.Usuario;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUsuarioInOrderByIdDesc(Set<Usuario> usuarios, Pageable pageable);
}
