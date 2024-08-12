package com.uniamerica.carros.app.controller;

import com.uniamerica.carros.app.entity.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uniamerica.carros.app.entity.Marca;
import com.uniamerica.carros.app.service.MarcaService;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Marca marca) {
		try {
			String mensagem = this.marcaService.save(marca);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Marca>> findAll() {
		try {
			List<Marca> marcas = marcaService.findAll();
			return new ResponseEntity<>(marcas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Marca marca, @PathVariable long id){
		try {
			String mensagem = this.marcaService.update(marca, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}

	@GetMapping("/findById/{idMarca}")
	public ResponseEntity<Marca> findById(@PathVariable long idMarca) {
		try {
			Marca marca = this.marcaService.findById(idMarca);
			if (marca != null) {
				return new ResponseEntity<>(marca, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@DeleteMapping("/delete/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable long idMarca) {
		try {
			String mensagem = this.marcaService.delete(idMarca);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Deu Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/findByNome")
	public ResponseEntity<List<Marca>> findByNome(@RequestParam String nome) {
		try {
			List<Marca> lista = this.marcaService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findByCnpj")
	public ResponseEntity<List<Marca>> findByCnpj(@RequestParam String cnpj) {
		try {
			List<Marca> lista = this.marcaService.findByCnpj(cnpj);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
