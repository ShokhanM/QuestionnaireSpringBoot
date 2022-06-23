package com.shokhan.springApp.service;


import com.shokhan.springApp.models.Question;
import com.shokhan.springApp.repositories.QuestionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements  QuestionService{

    private final QuestionRepo questionRepo;

    @Autowired
    public QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }


    public void save(Question question){
        List<Question> questionList = questionRepo.
                findAllByQuestionnaireId(question.getQuestionnaire().getId());
    }



}
