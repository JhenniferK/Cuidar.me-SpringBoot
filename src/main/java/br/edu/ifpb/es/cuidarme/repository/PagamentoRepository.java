package br.edu.ifpb.es.cuidarme.repository;

import br.edu.ifpb.es.cuidarme.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, String> {
    Optional<Pagamento> findById(String id);
    void deleteById(String id);
}
