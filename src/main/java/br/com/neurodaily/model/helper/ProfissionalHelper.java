package br.com.neurodaily.model.helper;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.PessoaContato;
import br.com.neurodaily.model.domain.Profissional;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProfissionalHelper implements Serializable {

    private Profissional profissional;
    private DocumentoPessoal documentoPessoal;
    private List<PessoaContato> pessoaContatos;

}
