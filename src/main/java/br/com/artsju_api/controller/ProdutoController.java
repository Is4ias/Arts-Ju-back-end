package br.com.artsju_api.controller;

import br.com.artsju_api.controller.dto.ProdutoDTO;
import br.com.artsju_api.controller.dto.ProdutoRequisicaoDTO;
import br.com.artsju_api.controller.dto.ProdutoRespostaDTO;
import br.com.artsju_api.model.Produto;
import br.com.artsju_api.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor

public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoRespostaDTO> cadastrar(@RequestBody @Valid ProdutoRequisicaoDTO dto){
        ProdutoRespostaDTO produto = produtoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id){
        Optional<Produto> produto = produtoService.obterPorId(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoRespostaDTO>> listarTodos() {
        List<ProdutoRespostaDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoRespostaDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoRequisicaoDTO dto){
        ProdutoRespostaDTO produtoAtualizado = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
