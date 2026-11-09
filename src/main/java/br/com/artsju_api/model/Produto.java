package br.com.artsju_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name="descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name= "preco" ,nullable = false)
    private BigDecimal preco;

    @Column(name="imagem")
    private String imagem;

    @Column(name = "tempo_de_producao")
    private String tempoDeProducao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
