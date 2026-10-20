package br.com.artsju_api.service;

import br.com.artsju_api.dto.CategoriaRequisicaoDTO;
import br.com.artsju_api.dto.CategoriaRespostaDTO;
import lombok.RequiredArgsConstructor;
import br.com.artsju_api.model.Categoria;
import org.springframework.stereotype.Service;
import br.com.artsju_api.repository.CategoriaRepositorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio repositorio;

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
}
