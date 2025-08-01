package br.edu.ifpb.es.cuidarme.repository;

import br.edu.ifpb.es.cuidarme.entities.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProntuarioRepository extends JpaRepository<Prontuario, String> {
    Optional<Prontuario> findByDataRegistro(LocalDateTime dataRegistro);
    void deleteByDataRegistro(LocalDateTime dataRegistro);
}
