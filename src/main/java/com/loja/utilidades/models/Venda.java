package com.loja.utilidades.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_venda")
    private LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false, length = 1)
    private String status = "P";

    @Column(nullable = false)
    private Double quantidade;

    @Column(name = "valor_total", nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaItem> produtos = new ArrayList<>();


}
