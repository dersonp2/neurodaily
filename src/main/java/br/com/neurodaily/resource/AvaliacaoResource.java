package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.service.NotaAvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nota_avaliacao")
public class AvaliacaoResource {

    @Autowired
    private NotaAvaliacaoService notaAvaliacaoService;

    @PostMapping
    public ResponseEntity<NotaAvaliacao> salvarProfissao(@RequestBody NotaAvaliacao notaAvaliacao){
        NotaAvaliacao n = notaAvaliacaoService.salvar(notaAvaliacao);
        return new ResponseEntity<NotaAvaliacao>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaAvaliacao> buscarNotaId(@PathVariable Long id){
        NotaAvaliacao n = notaAvaliacaoService.buscarNotaAvaliacao(id);
        return new ResponseEntity<NotaAvaliacao>(n, HttpStatus.OK);
    }

}
