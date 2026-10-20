package br.com.artsju_api.repository;

import br.com.artsju_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    boolean existsByTitulo(String title);

}
