package com.bcp.pe.moneda.repository;

import com.bcp.pe.moneda.entity.Moneda;
import com.bcp.pe.moneda.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
    public TipoCambio findByMonedaOrigenAndMonedaDestino(Moneda monedaOrigen, Moneda monedaDestino);
}
