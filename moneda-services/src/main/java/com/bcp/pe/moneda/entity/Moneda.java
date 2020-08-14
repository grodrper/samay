package com.bcp.pe.moneda.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_moneda")
@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String nombre;

}
