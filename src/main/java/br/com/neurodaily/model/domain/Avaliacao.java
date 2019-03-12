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
    private long id;

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
}
