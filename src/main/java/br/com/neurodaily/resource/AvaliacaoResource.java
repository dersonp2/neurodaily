package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Avaliacao;
import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.service.AvaliacaoService;
import br.com.neurodaily.service.NotaAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Avaliacao> salvarProfissao(@RequestBody Avaliacao avaliacao){
        Avaliacao n = avaliacaoService.salvar(avaliacao);
        return new ResponseEntity<Avaliacao>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarNotaId(@PathVariable Long id){
        Avaliacao n = avaliacaoService.buscarNotaAvaliacao(id);
        return new ResponseEntity<Avaliacao>(n, HttpStatus.OK);
    }

}
