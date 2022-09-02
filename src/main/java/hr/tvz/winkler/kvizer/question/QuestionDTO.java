package hr.tvz.winkler.kvizer.question;


public class QuestionDTO {

    private final Long id;
    private final Long position;
    private final String question;
    private final String answer;
    private final String quizCode;


    public QuestionDTO(Long id, Long position, String question, String answer, String quizCode) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
        this.quizCode = quizCode;
    }

    public Long getId() {return id;}

    public Long getPosition() {return position;}

    public String getQuestion() {return question;}

    public String getAnswer() {return answer;}


    public String getQuizCode() {return quizCode;}

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "position='" + position + '\'' +
                ", question=" + question +'\'' +
                ", answer=" + answer +'\'' +
                ", quizCode=" + quizCode +
                '}';
    }
}
