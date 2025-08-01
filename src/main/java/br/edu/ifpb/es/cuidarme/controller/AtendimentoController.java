package br.edu.ifpb.es.cuidarme.controller;

import br.edu.ifpb.es.cuidarme.entities.Atendimento;
import br.edu.ifpb.es.cuidarme.service.AtendimentoService;
import br.edu.ifpb.es.cuidarme.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    private final AtendimentoService service;

    public AtendimentoController(AtendimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Atendimento> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Atendimento create(@RequestBody Atendimento atendimento) {
        return service.salvar(atendimento);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("deletar/id/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
