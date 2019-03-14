package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND07_CONTATO" )
@SequenceGenerator(name = "ND07_CONTATO_SEQ", sequenceName = "ND07_CONTATO_SEQ", allocationSize = 1)
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND07_CONTATO_SEQ")
    @Column (name = "ND07_COD_CONTATO")
    private Long id;

    @Column (name = "ND07_DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "FKND07ND08_COD_TIPO_CONTATO")
    private TipoContato tipoContato;
}
