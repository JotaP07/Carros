package com.uniamerica.carros.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private int ano;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("carros")
	@JoinColumn(name = "marca_id")
	private Marca marca;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carro_acessorio")
	@JsonIgnoreProperties("carros")
	private List<Acessorio> acessorios;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carro_proprietario",
			joinColumns = @JoinColumn(name = "carro_id"),
			inverseJoinColumns = @JoinColumn(name = "proprietario_id"))
	@JsonIgnoreProperties("carros")
	private List<Proprietario> proprietarios;
}
