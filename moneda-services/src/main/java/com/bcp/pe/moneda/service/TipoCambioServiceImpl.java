package com.bcp.pe.moneda.service;

import com.bcp.pe.moneda.entity.Moneda;
import com.bcp.pe.moneda.entity.TipoCambio;
import com.bcp.pe.moneda.repository.TipoCambioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements  TipoCambioService{
    public final TipoCambioRepository tipoCambioRepository;


    @Override
    public TipoCambio getTipoCambioById(Long id) {
        return tipoCambioRepository.findById(id).orElse(null);
    }

    @Override
    public TipoCambio getTipoCambio(Moneda monedaOrigen, Moneda monedaDestino) {
        return tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
    }

    @Override
    public List<TipoCambio> getListAll() {
        return tipoCambioRepository.findAll();
    }

    @Override
    public TipoCambio createTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public TipoCambio updateTipoCambio(TipoCambio tipoCambio) {
        TipoCambio tipoCambioBd = getTipoCambioById(tipoCambio.getId());
        if (tipoCambioBd == null){
            return null;
        }
        tipoCambioBd.setCambio(tipoCambio.getCambio());
        return tipoCambioRepository.save(tipoCambioBd);
    }
}
