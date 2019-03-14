package br.com.neurodaily.model.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND10_PACIENTE" )
@SequenceGenerator(name = "ND10_PACIENTE_SEQ", sequenceName = "ND10_PACIENTE_SEQ", allocationSize = 1)
public class Paciente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND10_PACIENTE_SEQ")
    @Column(name = "ND10_COD_PACIENTE")
    private Long id;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column (name = "ND10_DATA_CADASTRO")
    private String dataCadastro;

    @Column (name = "ND10_MATRICULA")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "FKND10ND01_COD_PESSOA")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "FKND10ND01_COD_PESSOA_RESPONSAVEL")
    private Pessoa responsavel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }
}
