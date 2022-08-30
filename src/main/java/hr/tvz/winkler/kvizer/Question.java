package hr.tvz.winkler.kvizer;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private Long position;
    private String question;
    private String answer;
    private String imgPath;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    public Question() { }

    public Question(Long id, Long position, String question, String answer, String imgPath) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
        this.imgPath = imgPath;
    }

    public Question(Long id, Long position, String question, String answer, String imgPath, Quiz quiz) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
        this.imgPath = imgPath;
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

    public String getImgPath() {return imgPath;}

    public void setImgPath(String imgPath) {this.imgPath = imgPath;}

    public void setQuiz(Quiz quiz) {this.quiz = quiz;}

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuizList(Quiz quiz) {
        this.quiz = quiz;
    }
}
