package hr.tvz.winkler.kvizer.security.user.answer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnswerCommand {

    @NotNull(message = "Answer must have an ID")
    private Long id;

    private String answer;

    @NotNull (message = "Answer must belong to a question")
    private Long questionId;

    @NotNull (message = "Answer must belong to a user")
    private String userName;

    public AnswerCommand(Long id, String answer, Long questionId, String userName) {
        this.id = id;
        this.answer = answer;
        this.questionId = questionId;
        this.userName = userName;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getAnswer() {return answer;}

    public void setAnswer(String answer) {this.answer = answer;}

    public Long getQuestionId() {return questionId;}

    public void setQuestionId(Long questionId) {this.questionId = questionId;}

    public String getUserName() {return userName;}

    public void setUserName(String userId) {this.userName = userName;}
}
