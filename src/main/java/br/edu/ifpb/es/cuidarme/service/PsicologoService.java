package br.edu.ifpb.es.cuidarme.service;

import br.edu.ifpb.es.cuidarme.entities.Paciente;
import br.edu.ifpb.es.cuidarme.entities.Psicologo;
import br.edu.ifpb.es.cuidarme.repository.PsicologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsicologoService {

    @Autowired
    private PsicologoRepository repository;

    public Psicologo salvar(Psicologo Psicologo) {
        return repository.save(Psicologo);
    }

    public List<Psicologo> listarTodos() {
        return repository.findAll();
    }
}