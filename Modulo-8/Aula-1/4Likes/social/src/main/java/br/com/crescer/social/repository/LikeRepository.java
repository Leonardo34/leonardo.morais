package br.com.crescer.social.repository;

import br.com.crescer.social.models.Like;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {
    
}
