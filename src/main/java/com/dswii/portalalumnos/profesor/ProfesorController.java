package com.dswii.portalalumnos.profesor;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("profesores")
public class ProfesorController {
    ProfesorRepository profesorRepository; 

    @GetMapping
    public Page<Profesor> list(Pageable pageable) {
        return this.profesorRepository.findAll(pageable);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Profesor register(@RequestBody Profesor profesor) {
        return this.profesorRepository.save(profesor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profesor> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.profesorRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.profesorRepository.deleteById(id);
    }

    @PutMapping
    public Profesor edit(@RequestBody  Profesor profesor) {

        Profesor profesor2 = new Profesor();
        BeanUtils.copyProperties(profesor,profesor2);
        return this.profesorRepository.save(profesor2);
    }

}
