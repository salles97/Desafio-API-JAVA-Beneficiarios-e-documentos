package spring.boot.desafio.rocketseat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.rocketseat.domain.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
}
