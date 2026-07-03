package spring.boot.desafio.rocketseat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioRequest;
import spring.boot.desafio.rocketseat.domain.dto.BeneficiarioResponse;
import spring.boot.desafio.rocketseat.domain.dto.DocumentoDTO;
import spring.boot.desafio.rocketseat.mapper.BeneficiarioMapper;
import spring.boot.desafio.rocketseat.service.BeneficiarioService;

import java.lang.reflect.Parameter;
import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioResponse> criar(@RequestBody BeneficiarioRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioService.salvar(request));
    }

    @GetMapping
    public List<BeneficiarioResponse> listarTodos(){
        return beneficiarioService.listarBeneficiarios();
    }

    @GetMapping("/{id}/documentos")
    public List<DocumentoDTO> listarDocumentos(@RequestParam Long id){
        return  beneficiarioService.listarDocumentos(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> atualizar(@RequestBody BeneficiarioRequest request, @PathVariable Long id){
        return ResponseEntity.ok(beneficiarioService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public void deletarbeneficiario(@RequestParam Long id){
        beneficiarioService.remover(id);
    }

}
