package com.uniamerica.carros.app.service;

import com.uniamerica.carros.app.entity.Acessorio;
import com.uniamerica.carros.app.entity.Marca;
import com.uniamerica.carros.app.repository.AcessorioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String save(Acessorio acessorio) {
        this.acessorioRepository.save(acessorio);
        return acessorio.getNome() + " Acessório salvo com sucesso!";
    }

    public List<Acessorio> findAll() {
        return acessorioRepository.findAll();
    }

    public Acessorio findById(long id) {
        return acessorioRepository.findById(id).orElse(null);
    }

    public String update(Acessorio acessorio, long id) {
        if (acessorioRepository.existsById(id)) {
            acessorio.setId(id);
            acessorioRepository.save(acessorio);
            return "Acessório alterado com sucesso!";
        } else {
            return "Acessório não encontrado";
        }
    }

    public String delete(long id) {
        if (acessorioRepository.existsById(id)) {
            acessorioRepository.deleteById(id);
            return "Acessório deletado com sucesso";
        } else {
            return "Acessório não encontrado";
        }
    }

    public List<Acessorio> findByNome(String nome) {
        return acessorioRepository.findByNome(nome);
    }

}

