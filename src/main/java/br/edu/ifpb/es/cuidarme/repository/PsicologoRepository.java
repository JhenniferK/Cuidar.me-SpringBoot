package br.edu.ifpb.es.cuidarme.repository;

import br.edu.ifpb.es.cuidarme.entities.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findById(Long id);
    Optional<Psicologo> findByEmailAndSenha(String email, String senha);
}