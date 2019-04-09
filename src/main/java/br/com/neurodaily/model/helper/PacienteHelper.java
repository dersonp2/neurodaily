package br.com.neurodaily.model.helper;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.PessoaContato;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PacienteHelper implements Serializable {

    private Paciente paciente;
    private DocumentoPessoal documentoPessoal;
    private DocumentoPessoal documentoPessoalResponsavel;
    private List<PessoaContato> pessoaContatos;

}
