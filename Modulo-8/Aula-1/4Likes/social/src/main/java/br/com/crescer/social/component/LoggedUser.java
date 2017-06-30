package br.com.crescer.social.component;

import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.services.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author leonardo.morais
 */
@Component
public class LoggedUser {
    
    @Autowired
    private UsuarioService usuarioService;
    
    public Usuario getUsuarioLogado() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername)
                .map(usuarioService::findByEmail)
                .orElse(null);
    }
}
