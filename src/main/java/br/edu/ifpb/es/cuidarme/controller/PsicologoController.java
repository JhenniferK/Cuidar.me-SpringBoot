package br.edu.ifpb.es.cuidarme.controller;

import br.edu.ifpb.es.cuidarme.entities.Paciente;
import br.edu.ifpb.es.cuidarme.entities.Psicologo;
import br.edu.ifpb.es.cuidarme.repository.PsicologoRepository;
import br.edu.ifpb.es.cuidarme.service.PsicologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/psicologo")
public class PsicologoController {

    private final PsicologoService service;
    private final PsicologoRepository psicologoRepository;

    public PsicologoController(PsicologoService service, PsicologoRepository psicologoRepository) {
        this.service = service;
        this.psicologoRepository = psicologoRepository;
    }

    @PostMapping
    public Psicologo salvar(@RequestBody Psicologo psicologo) {
        return service.salvar(psicologo);
    }

    @GetMapping("/listar")
    public List<Psicologo> listar() {
        return service.listarTodos();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> login) {
        String email = login.get("email");
        String senha = login.get("senha");

        Optional<Psicologo> encontrado = psicologoRepository.findByEmailAndSenha(email, senha);

        if (encontrado.isPresent()) {
            return ResponseEntity.ok(encontrado.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválidos");
        }
    }
}
