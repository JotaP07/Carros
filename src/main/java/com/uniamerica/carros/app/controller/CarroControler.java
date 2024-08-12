package com.uniamerica.carros.app.controller;

import com.uniamerica.carros.app.entity.Carro;
import com.uniamerica.carros.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/carro")
public class CarroControler {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro) {
        try {
            String mensagem = this.carroService.save(carro);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll() {
        try {
            List<Carro> carros = carroService.findAll();
            return new ResponseEntity<>(carros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id){
        try {
            String mensagem = this.carroService.update(carro, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

	@GetMapping("/findById/{idCarro}")
	public ResponseEntity<Carro> findById(@PathVariable long idCarro) {
		try {
			Carro carro = this.carroService.findById(idCarro);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(  null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{idCarro}")
	public  ResponseEntity<String> delete(@PathVariable long idCarro){
		try {
			String mensagem = this.carroService.delete(idCarro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<String>("Deu Erro: " + e.getMessage(), HttpStatus.OK);
		}
	}

    @GetMapping("/findByNome")
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome) {
        try {
            List<Carro> lista = this.carroService.findByNome(nome) ;
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam long idMarca) {
       try {
            List<Carro> lista = this.carroService.findByMarca(idMarca) ;
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int ano) {
        try {
            List<Carro> lista = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
