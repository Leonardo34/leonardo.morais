package br.com.crescer.social.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;
    
    @Size(min = 1, max = 40, message = "o tamanho do nome deve estar entre {min} e {max}.")
    @Basic(optional = false)
    @Column(name = "NOME_USUARIO")
    private String nome;
    
    @Email
    @Size(min = 1, max = 40, message = "o tamanho do e-mail deve estar entre {min} e {max}.")
    @Basic(optional = false)
    @Column(name = "EMAIL_USUARIO")
    private String email;
    
    @Size(min = 1, max = 200, message = "a senha deve possuir entre {min} e {max} caracteres.")
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String senha;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amigos;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> convites;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @Column(name = "SEXO")
    private Character sexo;
    
    @Column(name = "IMAGEM_PERFIL")
    private String imagemPerfil;

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }

    public Set<Usuario> getConvites() {
        return convites;
    }

    public void setConvites(Set<Usuario> convites) {
        this.convites = convites;
    }
    
    @Override
    public boolean equals(Object user) {
        return this.id.equals(((Usuario)user).id);
    }
}
