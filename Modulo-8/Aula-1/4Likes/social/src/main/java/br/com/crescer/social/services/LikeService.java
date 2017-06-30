package br.com.crescer.social.services;

import br.com.crescer.social.models.Like;
import br.com.crescer.social.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    
    @Autowired
    private LikeRepository likeRepositorio;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Like save(Like like, User user, Long idPost) {
        like.setPost(postService.findById(idPost));
        like.setUsuarioCurtida(usuarioService.findByEmail(user.getUsername()));
        return likeRepositorio.save(like);
    }
    
    public void delete(Long id) {
        likeRepositorio.delete(id);
    }
}
