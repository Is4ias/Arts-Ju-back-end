package br.com.artsju_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, unique = true)
    private String titulo;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "imagem")
    private String imagem;

    // Assim, quando criar uma categoria pelo Builder sem informar produtos, a lista continuará inicializada.
    @Builder.Default
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos = new ArrayList<>();
}
