package br.com.crescer.social.services;

import br.com.crescer.social.models.Post;
import br.com.crescer.social.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepositorio;
    
    public Page<Post> findAll(Pageable pageable) {
        return postRepositorio.findAll(pageable);
    }

    public Iterable<Post> findAll() {
        return postRepositorio.findAll();
    }

    public void delete(Long id) {
        postRepositorio.delete(id);
    }

    public Post findById(Long id) {
        return postRepositorio.findOne(id);
    }

    public Post save(Post post) {
        return postRepositorio.save(post);
    }

    public Post update(Post post) {
        return postRepositorio.save(post);
    }
}
