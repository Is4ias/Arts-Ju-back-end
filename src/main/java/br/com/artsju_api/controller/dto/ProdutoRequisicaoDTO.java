package br.com.artsju_api.controller.dto;

import br.com.artsju_api.model.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

//DTO utilizado nos métodos POST e PUT com validações via @Valid:
public record ProdutoRequisicaoDTO(
        @NotBlank(message = "O título do produto é obrigatório!")
        String titulo,

        String descricao,

        @NotNull(message = "O preço do produto é obrigatório!")
        BigDecimal preco,

        @NotNull(message = "O tempo de produção é obrigatorio!")
        String tempoDeProducao,

        String imagem,

        @NotNull(message = "O ID da categoria é obrigatório!")
        Long categoriaId
) {
}
