package com.shokhan.springApp.repositories;


import com.shokhan.springApp.models.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionnaireRepo extends JpaRepository<Questionnaire, Integer> {

    @Override
    Optional<Questionnaire> findById(Integer integer);


}
