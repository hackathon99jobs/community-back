package br.com.community.community99jobs.controller;

import br.com.community.community99jobs.model.Aluno;
import br.com.community.community99jobs.model.Curso;
import br.com.community.community99jobs.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    public ResponseEntity<Curso> post(@RequestBody Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
