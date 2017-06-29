package br.com.crescer.aula7.controllers;

import br.com.crescer.aula7.models.Video;
import br.com.crescer.aula7.services.GeneroService;
import br.com.crescer.aula7.services.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    
    @Autowired
    private VideoService videoService;   
    
    @GetMapping(value = "/video")
    public List<Video> listVideos() {
        return videoService.list();
    }
    
    @GetMapping(value = "/video/{id}")
    public Video getVideo(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }
    
    @PostMapping(value = "/video")
    public void addVideo(@RequestBody Video video) {
        videoService.addVideo(video);
    }
    
    @DeleteMapping(value = "/video/{id}")
    public void removeVideo(@PathVariable Long id) {
        videoService.remove(videoService.getVideoById(id));
    }
    
    @PutMapping(value = "/video")
    public void updateVideo(@RequestBody Video video) {
        videoService.addVideo(video);
    }
}
