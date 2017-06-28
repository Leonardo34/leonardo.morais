package br.com.crescer.aula7.repositorys;

import br.com.crescer.aula7.models.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
    
}
