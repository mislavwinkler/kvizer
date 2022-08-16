package hr.tvz.winkler.kvizer;


public class QuestionDTO {

    private final Integer position;
    private final String question;
    private final String answer;


    public QuestionDTO(Integer position, String question, String answer) {
        this.position = position;
        this.question = question;
        this.answer = answer;
    }

    public Integer getPosition() {return position;}

    public String getQuestion() {return question;}

    public String getAnswer() {return answer;}

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "position='" + position + '\'' +
                ", question=" + question +'\'' +
                ", answer=" + answer +
                '}';
    }
}
