package com.bcp.pe.moneda.controller;

import com.bcp.pe.moneda.bean.ErrorMessage;
import com.bcp.pe.moneda.entity.TipoCambio;
import com.bcp.pe.moneda.service.TipoCambioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value="/tipocambios")
public class TipoCambioController {
    @Autowired
    TipoCambioService tipoCambioService;

    @GetMapping
    public ResponseEntity<List<TipoCambio>> ListTipoCambio(){
        List<TipoCambio> tipoCambios = null;
        tipoCambios = tipoCambioService.getListAll();
        if (tipoCambios.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tipoCambios);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoCambio> getTipoCambio(@PathVariable("id") Long id){
        TipoCambio tipoCambio = tipoCambioService.getTipoCambioById(id);
        if (tipoCambio == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoCambio);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<TipoCambio> updateProduct(@PathVariable("id") Long id, @RequestBody  TipoCambio tipoCambio){
        tipoCambio.setId(id);
        TipoCambio tipoCambioBD = tipoCambioService.updateTipoCambio(tipoCambio);
        if (tipoCambioBD == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoCambioBD);
    }

    /*Manejo de Error*/
    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getAllErrors().stream()
                .map(err ->{
                    Map<String, String> error = new HashMap<String, String>();
                    error.put(err.getCode(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        //Message Error
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        //Cast to Json
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try{
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }
}
