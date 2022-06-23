package com.shokhan.springApp.service;

import com.shokhan.springApp.models.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    public List<Questionnaire> findAll();
    public void save(Questionnaire questionnaire);
    public Questionnaire findById(int id);
    public void delete(int id);
    public void update(int id, Questionnaire questionnaire);

}
