package service;

import dto.CategoriaRequisicaoDTO;
import dto.CategoriaRespostaDTO;
import lombok.RequiredArgsConstructor;
import model.Categoria;
import org.springframework.stereotype.Service;
import repository.CategoriaRepositorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio repositorio;

    public CategoriaRespostaDTO salvar(CategoriaRequisicaoDTO dto){
        if(repositorio.getByTitle(dto.titulo())){
            throw new RuntimeException("Categoria existente!");
        }

        Categoria categoria = Categoria.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .imagem(dto.imagem())
                .build();

        Categoria salva = repositorio.save(categoria);
        return new CategoriaRespostaDTO(
                salva.getId(),
                salva.getTitulo(),
                salva.getDescricao(),
                salva.getImagem()
        );
    }

    public List<CategoriaRespostaDTO> listar() {

        return repositorio.findAll()
                .stream()
                .map(c -> new CategoriaRespostaDTO(
                        c.getId(),
                        c.getTitulo(),
                        c.getDescricao(),
                        c.getImagem()
                ))
                .toList();
    }
}
