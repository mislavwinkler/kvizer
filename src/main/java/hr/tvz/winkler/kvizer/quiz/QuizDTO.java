package hr.tvz.winkler.kvizer.quiz;


import java.util.Date;

public class QuizDTO {

    private final String code;
    private final String name;
    private final Date creationDate;
    private final String makerName;


    public QuizDTO(String code, String name, Date creationDate, String makerName) {
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
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

    public Date getCreationDate() {return creationDate;}

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", makerName=" + makerName +
                '}';
    }
}
