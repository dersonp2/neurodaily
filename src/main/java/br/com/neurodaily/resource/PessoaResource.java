package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.repository.PessoaRepository;
import br.com.neurodaily.service.DocumentoPessoalService;
import br.com.neurodaily.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa){
        Pessoa n = pessoaService.salvar(pessoa);
        return new ResponseEntity<Pessoa>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaId(@PathVariable Long id){
        Pessoa n = pessoaService.buscarPessoa(id.longValue());
        return new ResponseEntity<Pessoa>(n, HttpStatus.OK);
    }



}
