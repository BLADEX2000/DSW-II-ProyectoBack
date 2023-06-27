package com.dswii.portalalumnos.asignatura;


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
@RequestMapping("asignaturas")
public class AsignaturaController {

    AsignaturaRepository asignaturaRepository;

    @GetMapping
    public Page<Asignatura> list(Pageable pageable) {
        return this.asignaturaRepository.findAll(pageable);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Asignatura register(@RequestBody Asignatura asignatura) {
        return this.asignaturaRepository.save(asignatura);
    }

    @GetMapping("{id}")
    public ResponseEntity<Asignatura> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.asignaturaRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.asignaturaRepository.deleteById(id);
    }

    @PutMapping
    public Asignatura edit(@RequestBody  Asignatura asignatura) {

        Asignatura asignatura2 = new Asignatura();
        BeanUtils.copyProperties(asignatura,asignatura2);
        return this.asignaturaRepository.save(asignatura2);
    }
    
}
