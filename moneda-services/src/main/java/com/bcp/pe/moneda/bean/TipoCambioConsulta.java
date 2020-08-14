package com.bcp.pe.moneda.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TipoCambioConsulta {
    public BigDecimal monto         = new BigDecimal("0");
    public BigDecimal montoCambio   = new BigDecimal("0");
    public String monedaOrigen      = "";
    public String monedaDestino     = "";
    public BigDecimal tipoCambio    = new BigDecimal("0");

}
