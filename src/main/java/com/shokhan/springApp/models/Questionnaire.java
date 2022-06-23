package com.shokhan.springApp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Questionnaire")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Questionnaire {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "auto_gen", sequenceName = "questionnaire_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_gen")
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL)
    private List<Question> questionList;

    @ManyToMany
    @JsonIgnore
    @JoinColumn(referencedColumnName = "person_id", name = "id")
    private Person person;

}
