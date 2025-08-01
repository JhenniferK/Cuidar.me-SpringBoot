package br.edu.ifpb.es.cuidarme.repository;

import br.edu.ifpb.es.cuidarme.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {
    Optional<Atendimento> findByData(LocalDateTime data);
    void deleteByData(LocalDateTime data);
}
