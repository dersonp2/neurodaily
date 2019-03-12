package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.repository.ProfissaoRepository;
import br.com.neurodaily.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissao")
public class ProfissaoResource {

    @Autowired
    private ProfissaoService profissaoService;

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @PostMapping
    public ResponseEntity<Profissao> salvarProfissao(@RequestBody Profissao profissao){
        Profissao p = profissaoService.salvar(profissao);
        return new ResponseEntity<Profissao>(p, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Profissao>> listarProfissao(){
        return new ResponseEntity<List<Profissao>>(profissaoRepository.findAll(), HttpStatus.OK);
    }

}
