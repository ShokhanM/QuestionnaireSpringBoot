package com.shokhan.springApp.repositories;


import com.shokhan.springApp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

    List<Question> findAllByQuestionnaireId(int id);


}
