package br.com.artsju_api.controller;

import br.com.artsju_api.dto.CategoriaRequisicaoDTO;
import br.com.artsju_api.dto.CategoriaRespostaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.artsju_api.service.CategoriaService;

import java.util.List;

@Controller
@RestController
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
