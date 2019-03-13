package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND15_AVALIACAO" )
@SequenceGenerator(name = "ND15_AVALIACAO_SEQ", sequenceName = "ND15_AVALIACAO_SEQ", allocationSize = 1)
public class Avaliacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND15_AVALIACAO_SEQ")
    @Column (name = "ND15_COD_AVALIACAO")
    private Long id;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column (name = "ND15_DATA_AVALIACAO")
    private String dataAvaliacao;

    @Column (name = "ND15_DESCRICAO")
    private String descricao;

    @Column (name = "ND15_CONSIDERACAO")
    private String consideracao;

    @ManyToOne
    @JoinColumn(name = "FKND15ND16_COD_NOTA_AVALIACAO")
    private NotaAvaliacao notaAvaliacao;

    @ManyToOne
    @JoinColumn(name = "FKND15ND12_COD_PROFISSIONAL")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "FKND15ND10_COD_PACIENTE")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "FKND15ND21_COD_INSTITUICAO_ENDERECO")
    private InstituicaoEndereco instituicaoEndereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConsideracao() {
        return consideracao;
    }

    public void setConsideracao(String consideracao) {
        this.consideracao = consideracao;
    }

    public NotaAvaliacao getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(NotaAvaliacao notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public InstituicaoEndereco getInstituicaoEndereco() {
        return instituicaoEndereco;
    }

    public void setInstituicaoEndereco(InstituicaoEndereco instituicaoEndereco) {
        this.instituicaoEndereco = instituicaoEndereco;
    }
}
