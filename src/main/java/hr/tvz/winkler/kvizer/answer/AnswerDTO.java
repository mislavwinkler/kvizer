package hr.tvz.winkler.kvizer.answer;


public class AnswerDTO {

    private final Long id;
    private final String answer;
    private final Long questionId;
    private final String userName;

    public AnswerDTO(Long id, String answer, Long questionId, String userName) {
        this.id = id;
        this.answer = answer;
        this.questionId = questionId;
        this.userName = userName;
    }

    public Long getId() {return id;}

    public String getAnswer() {return answer;}

    public Long getQuestionId() {return questionId;}

    public String getUserName() {return userName;}

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id='" + id + '\'' +
                ", answer=" + answer +
                ", questionId=" + questionId +'\'' +
                ", userName=" + userName +'\'' +
                '}';
    }
}
