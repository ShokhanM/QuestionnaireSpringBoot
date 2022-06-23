package com.shokhan.springApp.repositories;


import com.shokhan.springApp.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer> {


    List<Answer> findAllByQuestionId(int id);

}
