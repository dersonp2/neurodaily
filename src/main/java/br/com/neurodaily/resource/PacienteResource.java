package br.com.neurodaily.resource;

import br.com.neurodaily.model.domain.Paciente;
import br.com.neurodaily.model.domain.Pessoa;
import br.com.neurodaily.repository.PacienteRepository;
import br.com.neurodaily.service.PacienteService;
import br.com.neurodaily.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteResource {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente){
        Paciente n = pacienteService.salvar(paciente);
        return new ResponseEntity<Paciente>(n, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacienteId(@PathVariable Long id){
        Paciente n = pacienteService.buscarPacienteId(id.longValue());
        return new ResponseEntity<Paciente>(n, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(@PathVariable Long id){
        return new ResponseEntity<List<Paciente>>(pacienteRepository.findAll(), HttpStatus.OK);
    }

}
