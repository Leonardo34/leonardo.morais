package br.com.crescer.social.controller;

import br.com.crescer.social.models.Comentario;
import br.com.crescer.social.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @PostMapping(value = "/comentario/{id}")
    public void adicionarPost(@RequestBody Comentario comentario, 
            @AuthenticationPrincipal User user, @PathVariable Long idPost) {
        comentarioService.save(comentario, user, idPost);
    }
}
