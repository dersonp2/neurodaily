package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND24_TIPO_ARQUIVO" )
@SequenceGenerator(name = "ND24_TIPO_ARQUIVO_SEQ", sequenceName = "ND24_TIPO_ARQUIVO_SEQ", allocationSize = 1)
public class TipoArquivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND24_TIPO_ARQUIVO_SEQ")
    @Column (name = "ND24_COD_TIPO_ARQUIVO")
    private long id;

    @Column (name = "ND24_DESCRICAO")
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
