package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.TipoArquivo;
import br.com.neurodaily.repository.ProfissaoRepository;
import br.com.neurodaily.service.ProfissaoService;
import br.com.neurodaily.service.TipoArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_arquivo")
public class TipoArquivoResource {

    @Autowired
    private TipoArquivoService tipoArquivoService;


    @PostMapping
    public ResponseEntity<TipoArquivo> salvarProfissao(@RequestBody TipoArquivo tipoArquivo){
        TipoArquivo t = tipoArquivoService.salvar(tipoArquivo);
        return new ResponseEntity<TipoArquivo>(t, HttpStatus.CREATED);
    }


}
