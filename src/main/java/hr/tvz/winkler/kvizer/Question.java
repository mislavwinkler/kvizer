package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.domain.Authority;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private Long position;
    private String question;
    private String answer;

    @ManyToMany
    @JoinTable(
            name = "quiz_question",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "quiz_id", referencedColumnName = "id")}
    )
    private List<Quiz> quizList;

    public Question() { }

    public Question(Long id, Long position, String question, String answer) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {this.position = position;}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
