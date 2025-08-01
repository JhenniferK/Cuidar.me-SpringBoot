package br.edu.ifpb.es.cuidarme.controller;

import br.edu.ifpb.es.cuidarme.entities.Psicologo;
import br.edu.ifpb.es.cuidarme.service.PsicologoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psicologo")
public class PsicologoController {

    private final PsicologoService service;

    public PsicologoController(PsicologoService service) {
        this.service = service;
    }

    @PostMapping
    public Psicologo salvar(@RequestBody Psicologo psicologo) {
        return service.salvar(psicologo);
    }
}
