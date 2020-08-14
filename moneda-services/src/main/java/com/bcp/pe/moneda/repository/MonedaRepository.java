package com.bcp.pe.moneda.repository;

import com.bcp.pe.moneda.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda, Long> {
    public Moneda findByNombre(String nombre);
}
