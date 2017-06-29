package br.com.crescer.aula7.services;

import br.com.crescer.aula7.models.Video;
import br.com.crescer.aula7.repositorys.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    
    @Autowired
    private VideoRepository generoRepositorio;
    
    public List<Video> list() {
        return (List) generoRepositorio.findAll();
    }
    
    public Video addVideo(Video video) {
        return generoRepositorio.save(video);
    }
    
    public void remove(Video video) {
        generoRepositorio.delete(video);
    }
    
    public Video getVideoById(Long id) {
        return generoRepositorio.findOne(id);
    }
}
