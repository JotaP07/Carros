package com.uniamerica.carros.app.service;

import com.uniamerica.carros.app.entity.Carro;
import com.uniamerica.carros.app.entity.Marca;
import com.uniamerica.carros.app.repository.CarroRepository;
import com.uniamerica.carros.app.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public String save (Carro carro) {
		this.carroRepository.save(carro);
		return "Carro cadastrado com sucesso";
	}

	public String update (Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Atualizado com sucesso";
	}

	public Carro findById (long idCarro) {
		Carro carro = this.carroRepository.findById(idCarro).get();
		return carro;
	}

	public List<Carro> findAll () {
		return this.carroRepository.findAll();
	}

	public String delete (long id) {
		this.carroRepository.deleteById(id);
		return "Veículo deletado com sucesso!";
	}

	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}

	public List<Carro> findAcimaAno(int ano){
		return this.carroRepository.findAcimaAno(ano);
	}

	public List<Carro> findByMarca(long idMarca) {
		Marca marca = new Marca();
		marca.setId(idMarca);
		return this.carroRepository.findByMarca(marca);
}
}

