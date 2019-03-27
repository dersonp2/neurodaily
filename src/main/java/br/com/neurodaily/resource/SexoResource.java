package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.NotaAvaliacao;
import br.com.neurodaily.model.domain.Profissao;
import br.com.neurodaily.model.domain.Sexo;
import br.com.neurodaily.repository.ProfissaoRepository;
import br.com.neurodaily.service.ProfissaoService;
import br.com.neurodaily.service.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sexo")
public class SexoResource {

    @Autowired
    private SexoService sexoService;

    @PostMapping
    public ResponseEntity<Sexo> sexoSalvar(@RequestBody Sexo sexo){
        Sexo p = sexoService.salvar(sexo);
        return new ResponseEntity<Sexo>(p, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sexo> buscarSexo(@PathVariable Long id){
        Sexo n = sexoService.buscarSexo(id);
        return new ResponseEntity<Sexo>(n, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Sexo>> listaSexo(){
        return new ResponseEntity<List<Sexo>>(sexoService.listaSexo(),HttpStatus.OK);
    }

}
