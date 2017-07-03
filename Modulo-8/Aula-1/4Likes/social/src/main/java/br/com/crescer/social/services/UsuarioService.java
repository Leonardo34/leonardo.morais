package br.com.crescer.social.services;

import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;
    
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepositorio.findAll(pageable);
    }

    public Iterable<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public void delete(Long id) {
        usuarioRepositorio.delete(id);
    }

    public Usuario findById(Long id) {
        return usuarioRepositorio.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

    public Usuario save(Usuario usuario) throws Exception {
        if (findByEmail(usuario.getEmail()) != null) {
            throw new Exception("Email já cadastrado no 4Likes");
        }
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return usuarioRepositorio.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
    
    public void enviarConviteAmizade(Usuario solicitante, Usuario requisitado) {
        requisitado.getConvites().add(solicitante);
        update(requisitado);
    }
    
    public void aceitarConviteAmizade(Usuario usuario, Usuario usuarioAdicionar) {
        usuario.getConvites().remove(usuarioAdicionar);
        usuario.getAmigos().add(usuarioAdicionar);
        usuarioAdicionar.getAmigos().add(usuario);
        update(usuario);
        update(usuarioAdicionar);
    }
    
    public void rejeitarConviteAmizade(Usuario usuario, Usuario usuarioARejeitar) {
        usuario.getConvites().remove(usuarioARejeitar);
        update(usuario);
    }
    
    public List<Usuario> findByNomeLike(String nome) {
        return usuarioRepositorio.findByNomeContainingIgnoreCase(nome);
    }
    
    public void removerAmigo(Usuario usuario, Usuario usuarioAExcluir) {
        usuario.getAmigos().remove(usuarioAExcluir);
        usuarioAExcluir.getAmigos().remove(usuario);
        update(usuario);
        update(usuarioAExcluir);
    }
}
