package hr.tvz.winkler.kvizer;


public class QuizDTO {

    private final String code;
    private final String name;
    private final String makerName;


    public QuizDTO(String code, String name, String makerName) {
        this.code = code;
        this.name = name;
        this.makerName = makerName;
    }

    public String getName() {
        return name;
    }

    public String getMakerName() {
        return makerName;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", makerName=" + makerName +
                '}';
    }
}
