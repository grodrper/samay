package com.bcp.pe.moneda.service;

import com.bcp.pe.moneda.entity.Moneda;
import com.bcp.pe.moneda.entity.TipoCambio;

import java.util.List;

public interface TipoCambioService {
    public TipoCambio getTipoCambioById(Long id);
    public TipoCambio getTipoCambio(Moneda monedaOrigen, Moneda monedaDestino);
    public List<TipoCambio> getListAll();
    public TipoCambio createTipoCambio(TipoCambio tipoCambio);
    public TipoCambio updateTipoCambio(TipoCambio tipoCambio);
}
