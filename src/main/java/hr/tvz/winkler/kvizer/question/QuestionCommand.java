package hr.tvz.winkler.kvizer.question;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionCommand {

    @NotNull(message = "Question must have an ID")
    private Long id;

    @NotNull(message = "Question must have a position in quiz")
    private Long position;

    @NotBlank(message = "There must be a question")
    private String question;

    @NotBlank(message = "There must be an answer")
    private String answer;

    @NotBlank (message = "Question must belong to a quiz")
    private String quizCode;

    public QuestionCommand(Long id, Long position, String question, String answer, String quizCode) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
        this.quizCode = quizCode;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getPosition() {return position;}

    public void setPosition(Long position) {this.position = position;}

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}

    public String getQuizCode() {return quizCode;}

    public void setQuizCode(String quizCode) {this.quizCode = quizCode;}
}
