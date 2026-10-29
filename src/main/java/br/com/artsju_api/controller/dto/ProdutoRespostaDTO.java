package br.com.artsju_api.controller.dto;


import java.math.BigDecimal;

//DTO de retorno para as respostas JSON do controller:
public record ProdutoRespostaDTO(
            Long id,
            String titulo,
            String descricao,
            BigDecimal price,
            String tempoDeProducao,
            String imagem,
            Long categoriaId ) {

}

