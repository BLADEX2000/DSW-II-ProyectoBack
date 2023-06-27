package com.dswii.portalalumnos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codusu;

    @NotBlank
    private String nomusu;

    @NotBlank
    private String apeusu;

    @NotBlank
    private String userusu;

    @NotBlank
    private String claveusu;

    @NotBlank
    private String estadousu;
}
