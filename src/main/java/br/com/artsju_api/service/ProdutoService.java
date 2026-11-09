package br.com.artsju_api.service;

import br.com.artsju_api.controller.dto.ProdutoDTO;
import br.com.artsju_api.controller.dto.ProdutoRequisicaoDTO;
import br.com.artsju_api.controller.dto.ProdutoRespostaDTO;
import lombok.RequiredArgsConstructor;
import br.com.artsju_api.model.Categoria;
import br.com.artsju_api.model.Produto;
import org.springframework.stereotype.Service;
import br.com.artsju_api.repository.CategoriaRepositorio;
import br.com.artsju_api.repository.ProdutoRepositorio;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositorio produtoRepositorio;
    //private final CategoriaRepositorio categoriaRepositorio;

    public ProdutoRespostaDTO cadastrar(ProdutoRequisicaoDTO dto){
        Produto produto = new Produto();
        produto.setTitulo(dto.titulo());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setImagem(dto.imagem());

        Produto produtoSalvo = produtoRepositorio.save(produto);
        return converterParaDTO(produtoSalvo);

    }
    public List<ProdutoRespostaDTO> listarTodos() {
        return produtoRepositorio.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public Optional<Produto> obterPorId(Long id){
        return produtoRepositorio.findById(id);
    }

    public ProdutoRespostaDTO atualizar(Long id, ProdutoRequisicaoDTO dto){
        Produto produtoExistente = produtoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto inexistente no banco!"));

        produtoExistente.setTitulo(dto.titulo());
        produtoExistente.setDescricao(dto.descricao());
        produtoExistente.setPreco(dto.preco());
        produtoExistente.setImagem(dto.imagem());

        Produto produtoAtualizado = produtoRepositorio.save(produtoExistente);
        return converterParaDTO(produtoAtualizado);
    }

    public void deletar(Long id){
        if (!produtoRepositorio.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        produtoRepositorio.deleteById(id);
    }
    private ProdutoRespostaDTO converterParaDTO(Produto produto) {
        return new ProdutoRespostaDTO(
                produto.getId(),
                produto.getTitulo(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getTempoDeProducao(),
                produto.getImagem(),
                produto.getCategoria() != null ? produto.getCategoria().getId() : null
        );
    }



}
