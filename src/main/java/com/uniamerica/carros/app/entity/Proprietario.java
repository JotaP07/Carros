package com.uniamerica.carros.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proprietario {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int idade;

    @ManyToMany(mappedBy = "proprietarios")
    @JsonIgnoreProperties("proprietarios")
    private List<Carro> carros;

}
