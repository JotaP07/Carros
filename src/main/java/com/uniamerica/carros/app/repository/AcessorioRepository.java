package com.uniamerica.carros.app.repository;

import com.uniamerica.carros.app.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uniamerica.carros.app.entity.Acessorio;

import java.util.List;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    public List<Acessorio> findByNome(String nome);
}
