package br.com.crescer.social.repository;

import br.com.crescer.social.models.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long> {
    
}
