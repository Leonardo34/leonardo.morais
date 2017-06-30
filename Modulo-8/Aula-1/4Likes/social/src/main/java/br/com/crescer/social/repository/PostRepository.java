package br.com.crescer.social.repository;

import br.com.crescer.social.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    
}
