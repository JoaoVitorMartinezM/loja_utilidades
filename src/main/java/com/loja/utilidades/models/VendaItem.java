package com.loja.utilidades.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venda_item")
public class VendaItem {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Double quantidade;

    @Column(name = "valor_unitario", nullable = false)
    private Double valorUnitario;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Venda venda;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Produto produto;


}
