package spring.boot.desafio.rocketseat.mapper;

import org.springframework.stereotype.Component;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioRequest;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioResponse;
import spring.boot.desafio.rocketseat.domain.dto.DocumentoDTO;
import spring.boot.desafio.rocketseat.domain.entity.Beneficiario;
import spring.boot.desafio.rocketseat.domain.entity.Documento;

import java.util.List;

@Component
public class BeneficiarioMapper {

    public Beneficiario toEntity(BeneficiarioRequest req){
        Beneficiario b = new Beneficiario();
        b.setNome(req.nome());
        b.setTelefone(req.telefone());
        b.setDataNascimento(req.dataNascimento());
        List<Documento> documentos = req.documentos().stream().map( d -> {
            Documento doc = new Documento();
            doc.setBeneficiario(b);
            doc.setDescricao(d.descricao());
            doc.setTipoDocumento(d.tipoDocumento());
            return doc;
        }).toList();
        b.setDocumentos(documentos);
        return b;
    }

    public BeneficiarioResponse toResponse(Beneficiario b){
        List<DocumentoDTO> docs = b.getDocumentos().stream().map(d -> new DocumentoDTO(  d.getTipoDocumento(), d.getDescricao())).toList();
        return new BeneficiarioResponse(b.getId(), b.getNome(), b.getTelefone(), b.getDataNascimento(), docs);
    }
}
