package br.edu.ifpb.es.cuidarme.service;

import br.edu.ifpb.es.cuidarme.entities.Paciente;
import br.edu.ifpb.es.cuidarme.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Paciente> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Optional<Paciente> atualizarPorCpf(String cpf, Paciente novosDados) {
        return repository.findByCpf(cpf).map(paciente -> {
            paciente.setNome(novosDados.getNome());
            paciente.setTelefonePessoal(novosDados.getTelefonePessoal());
            paciente.setEnderecoPessoal(novosDados.getEnderecoPessoal());
            paciente.setContatoEmergencia(novosDados.getContatoEmergencia());
            paciente.setEnderecoTrabalho(novosDados.getEnderecoTrabalho());
            return repository.save(paciente);
        });
    }

    public void deletarPorId(String id) {
        repository.deleteById(id);
    }

    public void deletarPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }
}
