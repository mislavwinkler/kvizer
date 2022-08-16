package hr.tvz.winkler.kvizer;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class QuestionCommand {

    @NotBlank(message = "Question must have a position in quiz")
    private Integer position;

    @NotBlank(message = "There must be a question")
    private String question;

    @NotBlank(message = "There must be an answer")
    private String answer;

    public QuestionCommand(Integer position, String question, String answer) {
        this.position = position;
        this.question = question;
        this.answer = answer;
    }

    public Integer getPosition() {return position;}

    public void setPosition(Integer position) {this.position = position;}

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}
}
