package controller;

import dto.CategoriaRequisicaoDTO;
import dto.CategoriaRespostaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CategoriaService;

import java.util.List;

@Controller
@RequestMapping("/categorias")
@RequiredArgsConstructor
@CrossOrigin("*")

public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public CategoriaRespostaDTO criarCategoria(@RequestBody CategoriaRequisicaoDTO dto){
        return categoriaService.salvar(dto);
    }

    @GetMapping
    public List<CategoriaRespostaDTO> listarCategorias(){
        return categoriaService.listar();
    }
}
