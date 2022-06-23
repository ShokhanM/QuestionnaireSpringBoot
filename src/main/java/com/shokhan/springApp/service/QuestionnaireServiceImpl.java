package com.shokhan.springApp.service;


import com.fasterxml.jackson.annotation.OptBoolean;
import com.shokhan.springApp.models.Answer;
import com.shokhan.springApp.models.Question;
import com.shokhan.springApp.models.Questionnaire;
import com.shokhan.springApp.repositories.AnswerRepo;
import com.shokhan.springApp.repositories.QuestionRepo;
import com.shokhan.springApp.repositories.QuestionnaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class QuestionnaireServiceImpl implements QuestionnaireService{

    private final QuestionnaireRepo questionnaireRepo;
    private final QuestionRepo questionRepo;
    private final AnswerRepo answerRepo;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireRepo questionnaireRepo, QuestionRepo questionRepo, AnswerRepo answerRepo) {
        this.questionnaireRepo = questionnaireRepo;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @Override
    public List<Questionnaire> findAll(){
        return questionnaireRepo.findAll();
    }


    public Questionnaire findById(int id){
        Optional<Questionnaire> questionnaire = questionnaireRepo.findById(id);
        return questionnaire.orElse(null);
    }

    @Override
    @Transactional
    public void save(Questionnaire questionnaire) {
        List<Question> questionList = questionnaire.getQuestionList();
        for (Question question : questionList){
            List<Answer> answerList = new ArrayList<>();
            question.setQuestionnaire(questionnaire);
            answerList.addAll(question.getAnswerList());
            for (Answer answer : answerList){
                answer.setQuestion(question);
            }
            answerRepo.saveAll(answerList);
        }

        questionRepo.saveAll(questionList);
        questionnaireRepo.save(questionnaire);
    }

    @Transactional
    public void update(int id, Questionnaire questionnaire){
        questionnaire.setId(id);
        questionnaireRepo.save(questionnaire);
    }

    @Transactional
    public void delete(int id){
        questionnaireRepo.deleteById(id);
    }

}
