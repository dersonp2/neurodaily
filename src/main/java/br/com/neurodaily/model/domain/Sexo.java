package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND11_SEXO" )
@SequenceGenerator(name = "ND11_SEXO_SEQ", sequenceName = "ND11_SEXO_SEQ", allocationSize = 1)
public class Sexo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND11_SEXO_SEQ")
    @Column (name = "ND11_COD_SEXO")
    private long id;

    @Column (name = "ND11_DESCRICAO")
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
