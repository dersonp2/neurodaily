package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND19_CONTATO" )
@SequenceGenerator(name = "ND07_CONTATO_SEQ", sequenceName = "ND07_CONTATO_SEQ", allocationSize = 1)
public class PessoaContato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND07_CONTATO_SEQ")
    @Column (name = "ND07_COD_CONTATO")
    private long id;

    @OneToOne
    @JoinColumn(name = "FKND19ND01_COD_PESSOA")
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "FKND19ND07_COD_CONTATO")
    private Contato contato;
}
