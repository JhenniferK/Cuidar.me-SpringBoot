package br.edu.ifpb.es.cuidarme.controller;

import br.edu.ifpb.es.cuidarme.entities.Pagamento;
import br.edu.ifpb.es.cuidarme.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagamento> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Pagamento salvar(@RequestBody Pagamento pagamento) {
        return service.salvar(pagamento);
    }

    @GetMapping("buscar/id/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@RequestParam String id) {
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
