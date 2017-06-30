package br.com.crescer.social.controller;

import br.com.crescer.social.models.Post;
import br.com.crescer.social.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    
    @PostMapping(value = "/post")
    public void adicionarPost(@RequestBody Post post, @AuthenticationPrincipal User user) {
        postService.save(post, user);
    }
    
    @GetMapping(value = "posts/{id}")
    public List<Post> getPostsByUser(@PathVariable Long id) {
        return postService.getPostsByUserId(id);
    }
    
    @GetMapping(value = "posts/feed")
    public List<Post> getFeedPosts(@AuthenticationPrincipal User user, Pageable pageable) {
        return postService.getFeedPosts(user, pageable);
    }
}
