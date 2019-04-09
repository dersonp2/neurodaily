package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Contato;
import br.com.neurodaily.model.domain.Sexo;
import br.com.neurodaily.repository.ContatoRepository;
import br.com.neurodaily.service.ContatoService;
import br.com.neurodaily.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoResource {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ContatoRepository  contatoRepository;

    @GetMapping
    public ResponseEntity<List<Contato>>  contatoLista(){
        return new ResponseEntity<List<Contato>>(contatoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contato> contatoSalvar(@RequestBody Contato Contato){
        Contato p = contatoService.salvar(Contato);
        return new ResponseEntity<Contato>(p, HttpStatus.CREATED);
    }


}
