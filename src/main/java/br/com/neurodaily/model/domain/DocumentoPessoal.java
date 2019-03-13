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
    private Long id;

    @Column (name = "ND02_CPF")
    private String cpf;

    @Column (name = "ND02_RG")
    private String rg;

    @Column (name = "ND02_SUS")
    private String sus;

    @Column (name = "ND02_DATA_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
//    @ManyToOne
//    @JoinColumn(name = "FKND02ND06_COD_ORGAO_EXPEDIDOR")
//    private OrgaoEspedidor orgaoEspedidor;
}
