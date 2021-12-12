package br.com.community.community99jobs.controller;

import br.com.community.community99jobs.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.community.community99jobs.repository.AlunoRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Aluno> put(@RequestBody Aluno aluno){
        return ResponseEntity.ok(repository.save(aluno));
    }

    @PostMapping
    public ResponseEntity<Aluno> post(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }
}
