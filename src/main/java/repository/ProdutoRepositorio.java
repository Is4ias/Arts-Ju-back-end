package repository;

import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

    //para retornar via GET apenas todos os produtos de uma determinada categoria
    List<Produto> fingByCategoriaId(Long categoriaId);
}
