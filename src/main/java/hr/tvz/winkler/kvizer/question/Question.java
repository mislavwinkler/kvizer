package hr.tvz.winkler.kvizer.question;

import hr.tvz.winkler.kvizer.quiz.Quiz;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private Long position;
    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    public Question() { }

    public Question(Long id, Long position, String question, String answer, Quiz quiz) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
        this.quiz = quiz;
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

    public void setQuiz(Quiz quiz) {this.quiz = quiz;}

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuizList(Quiz quiz) {
        this.quiz = quiz;
    }
}
