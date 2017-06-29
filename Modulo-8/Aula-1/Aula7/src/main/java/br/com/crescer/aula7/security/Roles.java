package br.com.crescer.aula7.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<Roles> valuesToList() {
        return Arrays.asList(Roles.values());
    }
}
