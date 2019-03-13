package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Profissional;
import br.com.neurodaily.repository.PacienteRepository;
import br.com.neurodaily.repository.ProfissionalRepository;
import br.com.neurodaily.service.PacienteService;
import br.com.neurodaily.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissional")
public class ProfissionalResource {

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @PostMapping
    public ResponseEntity<Profissional> salvarPaciente(@RequestBody Profissional profissional){
        Profissional n = profissionalService.salvar(profissional);
        return new ResponseEntity<Profissional>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarProfissionalId(@PathVariable Long id){
        Profissional n = profissionalService.buscarProfissionalId(id.longValue());
        return new ResponseEntity<Profissional>(n, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listarProfissionai(){
        return new ResponseEntity<List<Profissional>>(profissionalRepository.findAll(), HttpStatus.OK);
    }

}
