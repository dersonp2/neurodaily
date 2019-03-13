package br.com.neurodaily.model.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND12_PROFISSIONAL" )
@SequenceGenerator(name = "ND12_PROFISSIONAL_SEQ", sequenceName = "ND12_PROFISSIONAL_SEQ", allocationSize = 1)
public class Profissional implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND12_PROFISSIONAL_SEQ")
    @Column(name = "ND12_COD_PROFISSIONAL")
    private long id;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column (name = "ND12_DATA_CADASTRO")
    private String dataCadastro;

    @Column (name = "ND12_MATRICULA")
    private String matricula;

    @ManyToOne
    @JoinColumn (name = "FKND12ND13_COD_PROFISSAO")
    private Profissao profissao;

    @ManyToOne
    @JoinColumn (name = "FKND12ND01_COD_PESSOA")
    private Pessoa pessoa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
