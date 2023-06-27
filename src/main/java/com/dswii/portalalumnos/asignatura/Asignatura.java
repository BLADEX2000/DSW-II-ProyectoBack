package com.dswii.portalalumnos.asignatura;

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
import com.dswii.portalalumnos.profesor.Profesor;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idasig;

    @NotBlank
    private String desasig;

    @ManyToOne
    @JoinColumn(name = "idcar")
    private Carrera carrera;
    
    @ManyToOne
    @JoinColumn(name = "idgrado")
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "idprofesor")
    private Profesor profesor;
}
