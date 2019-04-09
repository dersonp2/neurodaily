package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND08_TIPO_CONTATO" )
@SequenceGenerator(name = "ND08_TIPO_CONTATO_SEQ", sequenceName = "ND08_TIPO_CONTATO_SEQ", allocationSize = 1)
public class TipoContato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND08_TIPO_CONTATO_SEQ")
    @Column (name = "ND08_COD_TIPO_CONTATO")
    private Long id;

    @Column (name = "ND08_DESCRICAO")
    private String descricao;
}
