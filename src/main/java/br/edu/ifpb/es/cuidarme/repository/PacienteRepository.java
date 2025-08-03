package br.edu.ifpb.es.cuidarme.repository;

import br.edu.ifpb.es.cuidarme.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
    Optional<Paciente> findByCpf(String cpf);
    void deleteByCpf(String cpf);
    void deleteById(Long id);
}
