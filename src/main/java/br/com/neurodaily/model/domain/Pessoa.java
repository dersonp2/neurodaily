package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ND01_PESSOA" )
@SequenceGenerator(name = "ND01_PESSOA_SEQ", sequenceName = "ND01_PESSOA_SEQ", allocationSize = 1)
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND01_PESSOA_SEQ")
    @Column (name = "ND01_COD_PESSOA")
    private long id;

    @Column (name = "ND01_NOME")
    private String nome;

    @Column (name = "ND01_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @ManyToOne
    @JoinColumn(name = "FKND01ND02_COD_DOCUMENTO_PESSOAL")
    private DocumentoPessoal documentoPessoal;

    @ManyToOne
    @JoinColumn(name = "FKND01ND11_COD_SEXO")
    private Sexo sexo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public DocumentoPessoal getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(DocumentoPessoal documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
