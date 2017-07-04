package br.com.crescer.social.controller;

import br.com.crescer.social.models.Like;
import br.com.crescer.social.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
    
    @Autowired
    private LikeService likeService;
    
    @PostMapping(value = "/like/{id}")
    public Like adicionarLike(@RequestBody Like like, 
            @AuthenticationPrincipal User user, @PathVariable Long id) {
        return likeService.save(like, user, id);
    }
    
    @PostMapping(value = "/deslike/{id}")
    public void removerLike(@PathVariable Long id) {
        likeService.delete(id);
    }
}
