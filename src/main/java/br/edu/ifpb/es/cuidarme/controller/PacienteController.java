package br.edu.ifpb.es.cuidarme.controller;


import br.edu.ifpb.es.cuidarme.service.PacienteService;
import br.edu.ifpb.es.cuidarme.entities.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Paciente> buscarPorCpf(@PathVariable String cpf) {
        return service.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/atualizar/cpf/{cpf}")
    public ResponseEntity<Paciente> atualizarPorCpf(@PathVariable String cpf, @RequestBody Paciente dadosAtualizados) {
        return service.atualizarPorCpf(cpf, dadosAtualizados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<Void> deletarPorCpf(@PathVariable String cpf) {
        service.deletarPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}