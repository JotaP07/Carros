package com.uniamerica.carros.app.repository;

import com.uniamerica.carros.app.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uniamerica.carros.app.entity.Marca;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long>{
    public List<Marca> findByNome(String nome);
    public List<Marca> findByCnpj(String cnpj);
}
