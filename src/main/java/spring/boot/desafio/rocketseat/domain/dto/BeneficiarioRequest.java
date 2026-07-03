package spring.boot.desafio.rocketseat.domain.dto;

import java.time.LocalDate;
import java.util.List;

public record BeneficiarioRequest(String nome, String telefone, LocalDate dataNascimento, List<DocumentoDTO> documentos) {
}
