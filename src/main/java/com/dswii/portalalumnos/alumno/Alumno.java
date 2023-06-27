package com.dswii.portalalumnos.alumno;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.dswii.portalalumnos.Carrera;
import com.dswii.portalalumnos.Grado;
import com.dswii.portalalumnos.Seccion;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idalumno;

    @NotBlank
    private String nomalumno;

    @NotBlank
    private String apealumno;

    @NotBlank
    private String telfalumno;

    @ManyToOne
    @JoinColumn(name = "idseccion")
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "idgrado")
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "idcar")
    private Carrera carrera;
}
