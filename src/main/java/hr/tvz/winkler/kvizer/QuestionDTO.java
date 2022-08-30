package hr.tvz.winkler.kvizer;


public class QuestionDTO {

    private final Long id;
    private final Long position;
    private final String question;
    private final String answer;


    public QuestionDTO(Long id, Long position, String question, String answer) {
        this.id = id;
        this.position = position;
        this.question = question;
        this.answer = answer;
    }

    public Long getId() {return id;}

    public Long getPosition() {return position;}

    public String getQuestion() {return question;}

    public String getAnswer() {return answer;}


    @Override
    public String toString() {
        return "QuestionDTO{" +
                "position='" + position + '\'' +
                ", question=" + question +'\'' +
                ", answer=" + answer +
                '}';
    }
}
