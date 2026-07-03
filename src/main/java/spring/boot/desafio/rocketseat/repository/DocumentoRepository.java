package spring.boot.desafio.rocketseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.rocketseat.domain.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
