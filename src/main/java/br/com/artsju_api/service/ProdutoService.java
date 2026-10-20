package br.com.artsju_api.service;

import lombok.RequiredArgsConstructor;
import br.com.artsju_api.model.Categoria;
import br.com.artsju_api.model.Produto;
import org.springframework.stereotype.Service;
import br.com.artsju_api.repository.CategoriaRepositorio;
import br.com.artsju_api.repository.ProdutoRepositorio;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositorio produtoRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    public Produto cadastrar(Produto produto, Long categoriaId){

        Categoria categoria = categoriaRepositorio
                .findById(categoriaId)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada!"));

        produto.setCategoria(categoria);

        return produtoRepositorio.save(produto);
    }
}
