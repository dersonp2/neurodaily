package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "ND02_DOCUMENTO_PESSOAL" )
@SequenceGenerator(name = "ND02_DOCUMENTO_PESSOAL_SEQ", sequenceName = "ND02_DOCUMENTO_PESSOAL_SEQ", allocationSize = 1)
public class DocumentoPessoal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND02_DOCUMENTO_PESSOAL_SEQ")
    @Column (name = "ND02_COD_DOCUMENTO_PESSOAL")
    private long id;

    @Column (name = "ND02_CPF")
    private String cpf;

    @Column (name = "ND02_RG")
    private String rg;

    @Column (name = "ND02_SUS")
    private String sus;

    @Column (name = "ND02_DATA_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "FKND02ND06_COD_ORGAO_EXPEDIDOR")
    private OrgaoEspedidor orgaoEspedidor;
}
