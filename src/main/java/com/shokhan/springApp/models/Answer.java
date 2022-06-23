package com.shokhan.springApp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer {

    @Id
    @SequenceGenerator(name = "auto_gen", sequenceName = "answer_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_gen")
    @Column(name = "id")
    private int id;

    @Column(name = "answer")
    private String answer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
