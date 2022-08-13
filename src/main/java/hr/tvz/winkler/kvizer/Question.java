package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.domain.Authority;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
public class Question {

    @Id
    private Integer id;
    private String question;
    private String answer;

    @ManyToMany
    @JoinTable(
            name = "quiz_question",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "quiz_id", referencedColumnName = "id")}
    )
    private List<Quiz> quizList;
}
