package com.uniamerica.carros.app.controller;

import com.uniamerica.carros.app.entity.Acessorio;
import com.uniamerica.carros.app.entity.Marca;
import com.uniamerica.carros.app.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("api/acessorio")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Acessorio acessorio) {
        try {
            String mensagem = this.acessorioService.save(acessorio);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(" Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Acessorio>> findAll() {
        try {
            List<Acessorio> acessorios = acessorioService.findAll();
            return new ResponseEntity<>(acessorios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable long id){
        try {
            String mensagem = this.acessorioService.update(acessorio, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro!"+e.getMessage(), HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping("/findById/{idAcessorio}")
    public ResponseEntity<Acessorio> findById(@PathVariable long idAcessorio) {
        try {
            Acessorio acessorio = this.acessorioService.findById(idAcessorio);
            if (acessorio != null) {
                return new ResponseEntity<>(acessorio, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idAcessorio}")
    public ResponseEntity<String> delete(@PathVariable long idAcessorio) {
        try {
            String mensagem = this.acessorioService.delete(idAcessorio);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu Erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findByNome")
    public ResponseEntity<List<Acessorio>> findByNome(@RequestParam String nome) {
        try {
            List<Acessorio> lista = this.acessorioService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
