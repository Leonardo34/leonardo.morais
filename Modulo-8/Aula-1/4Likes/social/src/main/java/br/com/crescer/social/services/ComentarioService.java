package br.com.crescer.social.services;

import br.com.crescer.social.models.Comentario;
import br.com.crescer.social.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepositorio;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Comentario save(Comentario comentario, User user, Long idPost) {
        comentario.setPost(postService.findById(idPost));
        comentario.setUsuario(usuarioService.findByEmail(user.getUsername()));
        return comentarioRepositorio.save(comentario);
    }
    
    public void delete(Long id) {
        comentarioRepositorio.delete(id);
    }
}
