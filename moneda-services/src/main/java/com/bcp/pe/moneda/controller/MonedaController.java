package com.bcp.pe.moneda.controller;

import com.bcp.pe.moneda.bean.TipoCambioConsulta;
import com.bcp.pe.moneda.entity.TipoCambio;
import com.bcp.pe.moneda.service.TipoCambioService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static io.reactivex.rxjava3.core.Observable.fromArray;

@Slf4j
@RestController
@RequestMapping(value="/cambio")
public class MonedaController {
    @Autowired
    TipoCambioService tipoCambioService;

    @PostMapping
    public ResponseEntity<TipoCambioConsulta> getTipoCambio(@RequestBody TipoCambioConsulta consultaTipoCambio){
        log.info("[getTipoCambio] Inicio");
        if (consultaTipoCambio == null || consultaTipoCambio.getMonto() == null || consultaTipoCambio.getMonto().compareTo(new BigDecimal("0"))<0){
            return ResponseEntity.ok(consultaTipoCambio);
        }
        //Listado de Tipos de cambio
        List<TipoCambio> listaTipoCambio = tipoCambioService.getListAll();
        //Realizamos la conversión del tipo de cambio
        Observable<List<TipoCambio>> obsConsulta = fromArray(listaTipoCambio);
        obsConsulta.fromIterable(listaTipoCambio).filter(y ->  y.getMonedaOrigen().getNombre().equalsIgnoreCase(consultaTipoCambio.getMonedaOrigen()) &&
                                                        y.getMonedaDestino().getNombre().equalsIgnoreCase(consultaTipoCambio.getMonedaDestino())).toList()
        .subscribe(new Consumer<List<TipoCambio>>() {
            @Override
            public void accept(List<TipoCambio> tipoCambios) throws Throwable {
                log.info("[getTipoCambio] tipoCambios:"+tipoCambios);
                if (!tipoCambios.isEmpty()){
                    tipoCambios.forEach(p -> setDatosConversion(p,consultaTipoCambio));
                }
            }
        });

        log.info("[getTipoCambio] Fin");
        return ResponseEntity.ok(consultaTipoCambio);
    }

    /*Permite asignar los datos de la conversion*/
    private void setDatosConversion(TipoCambio tipoCambio, TipoCambioConsulta tipoCambioConsulta){
        tipoCambioConsulta.setTipoCambio    (BigDecimal.valueOf(tipoCambio.getCambio()).setScale(2, RoundingMode.HALF_UP));
        tipoCambioConsulta.setMontoCambio   (tipoCambioConsulta.getMonto().multiply(BigDecimal.valueOf(tipoCambio.getCambio())).setScale(2, RoundingMode.HALF_UP));
        tipoCambioConsulta.setMonto         (tipoCambioConsulta.getMonto().setScale(2, RoundingMode.HALF_UP));
        tipoCambioConsulta.setMonedaDestino (tipoCambioConsulta.getMonedaDestino().toUpperCase());
        tipoCambioConsulta.setMonedaOrigen  (tipoCambioConsulta.getMonedaOrigen().toUpperCase());
    }

}
