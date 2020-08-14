package com.bcp.pe.moneda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tbl_tipo_cambio")
public class TipoCambio {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La moneda origen no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_origen_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Moneda monedaOrigen;

    @NotNull(message = "La moneda origen no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneda_destino_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Moneda monedaDestino;

    @Positive (message = "El valor del tipo de cambio debe ser mayor que cero")
    private Double cambio;





}
