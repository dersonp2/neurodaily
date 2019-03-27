package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.DocumentoPessoal;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.service.DocumentoPessoalService;
import br.com.neurodaily.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documento_pessoal")
public class DocumentoPessoalResource {

    @Autowired
    private DocumentoPessoalService documentoPessoalService;

    @PostMapping
    public ResponseEntity<DocumentoPessoal> salvarDocumentoPessoal(@RequestBody DocumentoPessoal documentoPessoal ){
        DocumentoPessoal n = documentoPessoalService.salvar(documentoPessoal);
        return new ResponseEntity<DocumentoPessoal>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoPessoal> buscarDocumentoPessoal(@PathVariable Long id){
        DocumentoPessoal n = documentoPessoalService.buscarDocumentoPessoal(id.longValue());
        return new ResponseEntity<DocumentoPessoal>(n, HttpStatus.OK);
    }

    @GetMapping("/cpf/{id}")
    public ResponseEntity<DocumentoPessoal> buscarDocumentoPessoalCpf(@PathVariable String id){
        DocumentoPessoal n = documentoPessoalService.buscarCpf(id);
        return new ResponseEntity<DocumentoPessoal>(n, HttpStatus.OK);
    }



}
