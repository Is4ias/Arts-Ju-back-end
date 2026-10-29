package br.com.artsju_api.service;

import br.com.artsju_api.controller.dto.CategoriaRequisicaoDTO;
import br.com.artsju_api.controller.dto.CategoriaRespostaDTO;
import br.com.artsju_api.repository.ProdutoRepositorio;
import lombok.RequiredArgsConstructor;
import br.com.artsju_api.model.Categoria;
import org.springframework.stereotype.Service;
import br.com.artsju_api.repository.CategoriaRepositorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio repositorio;
    private final ProdutoRepositorio produtoRepositorio;

    public CategoriaRespostaDTO salvar(CategoriaRequisicaoDTO dto){
        if(repositorio.existsByTitulo((dto.titulo()))){
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

    public CategoriaRespostaDTO atualizar(Long id, CategoriaRequisicaoDTO dto){

        Categoria categoria = repositorio.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada!"));

        if(repositorio.existsByTituloAndIdNot(dto.titulo(), id)) {
            throw new RuntimeException(
                    "Categoria Existente!"
            );
        };

        categoria.setTitulo(dto.titulo());
        categoria.setDescricao(dto.descricao());
        categoria.setImagem(dto.imagem());

        Categoria categoria_atualizada = repositorio.save(categoria);

        return new CategoriaRespostaDTO(
                categoria_atualizada.getId(),
                categoria_atualizada.getTitulo(),
                categoria_atualizada.getDescricao(),
                categoria_atualizada.getImagem()
        );

    }
    public void deletar(Long id){
        Categoria categoria = repositorio.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada!"));

        if(produtoRepositorio.existsByCategoria_Id(id)){
            throw new RuntimeException(
                    "Não é possível excluir uma categoria que possui produtos associados!");
        }

        repositorio.delete(categoria);
    }


}
