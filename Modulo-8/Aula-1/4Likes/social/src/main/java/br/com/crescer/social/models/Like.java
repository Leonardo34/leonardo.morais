package br.com.crescer.social.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Curtida")
public class Like implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LIKE")
    @SequenceGenerator(name = "SEQ_LIKE", sequenceName = "SEQ_LIKE", allocationSize = 1)
    @Column(name = "ID_CURTIDA")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_CURTIDA")
    private Usuario usuarioCurtida;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_POST")
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioCurtida() {
        return usuarioCurtida;
    }

    public void setUsuarioCurtida(Usuario usuarioCurtida) {
        this.usuarioCurtida = usuarioCurtida;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
