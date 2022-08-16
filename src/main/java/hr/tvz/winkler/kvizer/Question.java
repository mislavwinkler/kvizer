package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.domain.Authority;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    private Integer id;
    private Integer position;
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

    public Question(Integer position, String question, String answer) {
        this.position = position;
        this.question = question;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

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
