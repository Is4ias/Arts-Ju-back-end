package repository;

import model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    boolean getByTitle(String title);

}
