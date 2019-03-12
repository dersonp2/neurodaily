package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND13_PROFISSAO" )
@SequenceGenerator(name = "ND13_PROFISSAO_SEQ", sequenceName = "ND13_PROFISSAO_SEQ", allocationSize = 1)
public class Profissao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND13_PROFISSAO_SEQ")
    @Column(name = "ND13_COD_PROFISSAO")
    private long id;

    @Column (name = "ND13_DESCRICAO")
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
