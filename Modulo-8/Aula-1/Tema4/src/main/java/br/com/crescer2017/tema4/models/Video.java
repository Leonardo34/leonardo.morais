package br.com.crescer2017.tema4.models;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VIDEO")
public class Video {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO", allocationSize=1)
    private Long id;
    
    @Column(name = "VALOR")
    private BigDecimal valor;
    
    @Column(name = "DURACAO")
    @Basic(optional = false)
    private String duracao;
    
    @Column(name = "NOME")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @Column(name = "QUANTIDADE_ESTOQUE")
    private int quantidadeEstoque;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
