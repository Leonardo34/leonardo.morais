package br.com.crescer.social.repository;

import br.com.crescer.social.models.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    
}
