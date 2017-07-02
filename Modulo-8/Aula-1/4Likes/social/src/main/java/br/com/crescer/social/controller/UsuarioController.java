package br.com.crescer.social.controller;

import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.services.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;   
    
    @GetMapping(value = "/usuario")
    public List<Usuario> listUsuarios() {
        return (List) usuarioService.findAll();
    }
    
    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
    
    @PostMapping(value = "/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }
    
    @PostMapping(value = "/usuario/convite/{id}")
    public void enviarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario usuarioLogado = usuarioService.findByEmail(user.getUsername());
        Usuario usuarioSolicitado = usuarioService.findById(id);
        usuarioService.enviarConviteAmizade(usuarioLogado, usuarioSolicitado);
    }
    
    @PostMapping(value = "/usuario/aceitar/{id}")
    public void aceitarConvite(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Usuario usuarioLogado = usuarioService.findByEmail(user.getUsername());
        Usuario usuarioAceitar = usuarioService.findById(id);
        usuarioService.aceitarConviteAmizade(usuarioLogado, usuarioAceitar);
    }
    
    @DeleteMapping(value = "/usuario/{id}")
    public void removeUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }
    
    @PutMapping(value = "/usuario")
    public void updateUsuario(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
    }
    
    @GetMapping(value = "/usuario/amigos")
    public Set<Usuario> getAmigosUsuario(@AuthenticationPrincipal User user) {
        return usuarioService.findByEmail(user.getUsername()).getAmigos();
    }
    
    @GetMapping(value = "/usuario/convites")
    public Set<Usuario> getConvites(@AuthenticationPrincipal User user) {
        return usuarioService.findByEmail(user.getUsername()).getConvites();
    }
    
    @GetMapping(value = "/usuario/amigos/{id}")
    public Set<Usuario> getAmigosByIdUsuario(@PathVariable Long id) {
        return usuarioService.findById(id).getAmigos();
    }
    
    @GetMapping(value = "usuario/name")
    public List<Usuario> getUsuariosByName(@RequestParam String nome) {
        return usuarioService.findByNomeLike("%" + nome + "%");
    }
    
    @GetMapping("/usuarioLogado")
    public Map<String, Usuario> listarUsuarios(@AuthenticationPrincipal User user) {
        final Map<String, Usuario> hashMap = new HashMap<>();
        hashMap.put("dados", usuarioService.findByEmail(user.getUsername()));
        return hashMap;
    }
}
