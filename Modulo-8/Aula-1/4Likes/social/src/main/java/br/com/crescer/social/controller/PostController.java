package br.com.crescer.social.controller;

import br.com.crescer.social.models.Post;
import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.services.PostService;
import br.com.crescer.social.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping(value = "/post")
    public void adicionarPost(@RequestBody Post post, @AuthenticationPrincipal User user) {
        Usuario usuarioLogado = usuarioService.findByEmail(user.getUsername());
        post.setUsuario(usuarioLogado);
        postService.save(post);
    }
    
    @GetMapping(value = "posts/{id}")
    public List<Post> getPostsUser(@PathVariable Long id) {
        return usuarioService.findById(id).getPosts();
    }
    
}
