package br.com.neurodaily.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ND18_PESSOA_ENDERECO" )
@SequenceGenerator(name = "ND18_PESSOA_ENDERECO_SEQ", sequenceName = "ND18_PESSOA_ENDERECO_SEQ", allocationSize = 1)
public class PessoaEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ND18_PESSOA_ENDERECO_SEQ")
    @Column (name = "ND18_COD_PESSOA_ENDERECO")
    private long id;

    @OneToOne
    @JoinColumn(name = "FKND18ND09_COD_ENDERECO")
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "FKND18ND01_COD_PESSOA")
    private Pessoa pessoa;
}
