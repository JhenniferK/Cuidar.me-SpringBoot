package br.edu.ifpb.es.cuidarme.service;

import br.edu.ifpb.es.cuidarme.entities.Paciente;
import br.edu.ifpb.es.cuidarme.repository.PacienteRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Optional<Paciente> atualizarPorCpf(String cpf, Paciente novosDados) {
        return repository.findByCpf(cpf).map(paciente -> {
            paciente.setNome(novosDados.getNome());
            paciente.setDataNascimento(novosDados.getDataNascimento());
            paciente.setTelefonePessoal(novosDados.getTelefonePessoal());
            paciente.setEnderecoPessoal(novosDados.getEnderecoPessoal());
            paciente.setEnderecoTrabalho(novosDados.getEnderecoTrabalho());
            paciente.setInfoAdicionais(novosDados.getInfoAdicionais());
            paciente.setContatoEmergencia(novosDados.getContatoEmergencia());
            return repository.save(paciente);
        });
    }

    @Transactional
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deletarPorCpf(String cpf) {
        repository.deleteByCpf(cpf);
    }
}
