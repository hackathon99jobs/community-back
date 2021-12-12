package br.com.community.community99jobs.controller;

import br.com.community.community99jobs.model.Aluno;
import br.com.community.community99jobs.model.Mentor;
import br.com.community.community99jobs.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    public MentorRepository repository;

    @GetMapping
    public ResponseEntity<List<Mentor>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mentor> get(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mentor> post(@RequestBody Mentor mentor){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(mentor));
    }
}
