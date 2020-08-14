package com.bcp.pe.moneda.service;

import com.bcp.pe.moneda.entity.Moneda;
import com.bcp.pe.moneda.entity.TipoCambio;
import com.bcp.pe.moneda.repository.MonedaRepository;
import com.bcp.pe.moneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonedaServiceImpl  implements MonedaService{

    private final MonedaRepository monedaRepository;

    @Override
    public Moneda getMoneda(String nombre) {
        return monedaRepository.findByNombre(nombre);
    }
}
