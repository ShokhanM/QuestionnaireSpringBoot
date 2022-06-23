package com.shokhan.springApp.controllers;


import com.shokhan.springApp.models.Questionnaire;
import com.shokhan.springApp.service.QuestionnaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }


    @GetMapping("")
    public ResponseEntity<List<Questionnaire>> index(){
        return ResponseEntity.ok().body(questionnaireService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> findById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(questionnaireService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        questionnaireService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Questionnaire questionnaire){
        questionnaireService.save(questionnaire);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") int id, @RequestBody Questionnaire questionnaire){
        questionnaireService.update(id, questionnaire);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
