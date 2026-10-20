package br.com.artsju_api.repository;

import br.com.artsju_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

    //para retornar via GET apenas todos os produtos de uma determinada categoria
    List<Produto> findByCategoriaId(Long categoriaId);
}
