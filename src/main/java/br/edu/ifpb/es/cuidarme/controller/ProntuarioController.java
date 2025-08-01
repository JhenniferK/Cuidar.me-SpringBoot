package br.edu.ifpb.es.cuidarme.controller;

import br.edu.ifpb.es.cuidarme.entities.Prontuario;
import br.edu.ifpb.es.cuidarme.service.ProntuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prontuario> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<Prontuario> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/id/{id}")
    public ResponseEntity<Prontuario> atualizarPorId(@PathVariable String id, @RequestBody Prontuario dadosAtualizados) {
        return service.atualizarPorId(id, dadosAtualizados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("deletar/id/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}