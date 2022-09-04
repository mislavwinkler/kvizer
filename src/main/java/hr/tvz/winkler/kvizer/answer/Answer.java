package hr.tvz.winkler.kvizer.answer;

import hr.tvz.winkler.kvizer.question.Question;
import hr.tvz.winkler.kvizer.security.domain.User;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private String answer;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Answer() { }

    public Answer(Long id, String answer, Question question, User user) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}

    public Question getQuestion() {return question;}

    public void setQuestion(Question question) {this.question = question;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
