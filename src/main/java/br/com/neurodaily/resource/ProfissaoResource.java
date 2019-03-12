package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissao")
public class ProfissaoResource {

    @Autowired
    private ProfissaoService profissaoService;

    @PostMapping
    public ResponseEntity<Profissao> salvarProfissao(@RequestBody Profissao profissao){
        Profissao p = profissaoService.salvar(profissao);
        return new ResponseEntity<Profissao>(p, HttpStatus.CREATED);
    }
}
