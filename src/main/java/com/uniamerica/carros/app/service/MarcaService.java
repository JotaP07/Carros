package com.uniamerica.carros.app.service;

import com.uniamerica.carros.app.entity.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniamerica.carros.app.entity.Marca;
import com.uniamerica.carros.app.repository.MarcaRepository;

import java.util.List;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	public String save(Marca marca) {
		marcaRepository.save(marca);
		return marca.getNome() + " salvo com sucesso";
	}

	public List<Marca> findAll() {
		return marcaRepository.findAll();
	}

	public Marca findById(long id) {
		return marcaRepository.findById(id).orElse(null);
	}

	public String update(Marca marca, long id) {
		if (marcaRepository.existsById(id)) {
			marca.setId(id);
			marcaRepository.save(marca);
			return "Marca atualizada com sucesso";
		} else {
			return "Marca não encontrada";
		}
	}

	public String delete(long id) {
		if (marcaRepository.existsById(id)) {
			marcaRepository.deleteById(id);
			return "Marca deletada com sucesso";
		} else {
			return "Marca não encontrada";
		}
	}

	public List<Marca> findByNome(String nome) {
		return marcaRepository.findByNome(nome);
	}

	public List<Marca> findByCnpj(String cnpj) {
		return marcaRepository.findByCnpj(cnpj);
	}
}
