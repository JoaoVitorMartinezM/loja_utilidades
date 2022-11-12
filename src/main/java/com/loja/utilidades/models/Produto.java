package com.loja.utilidades.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false,unique = true, length = 6)
    private String sku;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 100)
    private String descricao;

}
