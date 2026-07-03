package spring.boot.desafio.rocketseat.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioRequest;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioResponse;
import spring.boot.desafio.rocketseat.domain.dto.DocumentoDTO;
import spring.boot.desafio.rocketseat.domain.entity.Beneficiario;
import spring.boot.desafio.rocketseat.domain.entity.Documento;
import spring.boot.desafio.rocketseat.mapper.BeneficiarioMapper;
import spring.boot.desafio.rocketseat.repository.BeneficiarioRepository;

import java.util.List;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioMapper beneficiarioMapper;

    public BeneficiarioService(BeneficiarioMapper beneficiarioMapper, BeneficiarioRepository beneficiarioRepository){
        this.beneficiarioMapper = beneficiarioMapper;
        this.beneficiarioRepository = beneficiarioRepository;
    }

   public BeneficiarioResponse salvar(BeneficiarioRequest  request){
        Beneficiario b = beneficiarioMapper.toEntity(request);
        return beneficiarioMapper.toResponse(beneficiarioRepository.save(b));
   }

   public List<BeneficiarioResponse> listarBeneficiarios(){
        return beneficiarioRepository.findAll().stream().map(beneficiarioMapper::toResponse).toList();
   }

    public List<DocumentoDTO> listarDocumentos(Long id){
        Beneficiario b = beneficiarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Beneficiario Não Encontrado"));
        return b.getDocumentos().stream().map( d -> new DocumentoDTO(d.getTipoDocumento(), d.getDescricao()) ).toList();
    }

    public void remover(Long id){
        if (!beneficiarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Id do beneficiario não encontrado");
        }

        beneficiarioRepository.deleteById(id);
    }

    public BeneficiarioResponse atualizar(Long id, BeneficiarioRequest request){
        Beneficiario b = beneficiarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id do beneficiario não encontrado"));
        b.setNome(request.nome());
        b.setTelefone(request.telefone());
        b.setDataNascimento(request.dataNascimento());
        b.getDocumentos().clear();
        for (DocumentoDTO dto : request.documentos()){
            Documento d = new Documento();
            d.setDescricao(dto.descricao());
            d.setTipoDocumento(dto.tipoDocumento());
            d.setBeneficiario(b);
            b.getDocumentos().add(d);
        }
        return beneficiarioMapper.toResponse(beneficiarioRepository.save(b));
    }
}
