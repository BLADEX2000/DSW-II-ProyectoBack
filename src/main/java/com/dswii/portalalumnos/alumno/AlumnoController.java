package com.dswii.portalalumnos.alumno;

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
@RequestMapping("alumnos")
public class AlumnoController {
    AlumnoRepository alumnoRepository;

    @GetMapping
    public Page<Alumno> list(Pageable pageable) {
        return this.alumnoRepository.findAll(pageable);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public  Alumno register(@RequestBody Alumno alumno) {
        return this.alumnoRepository.save(alumno);
    }

    @GetMapping("{id}")
    public ResponseEntity<Alumno> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.alumnoRepository.findById(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.alumnoRepository.deleteById(id);
    }

    @PutMapping
    public Alumno edit(@RequestBody  Alumno alumno) {
        Alumno alumno2 = new Alumno();
        BeanUtils.copyProperties(alumno,alumno2);
        return this.alumnoRepository.save(alumno2);
    }

}
