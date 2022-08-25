package hr.tvz.winkler.kvizer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class QuizCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Quiz must have a code")
    private String code;

    @NotNull(message = "Date od creation is mandatory")
    private Date creationDate;

    @NotBlank(message = "Quiz must have a maker")
    private String makerName;

    public QuizCommand() {
    }

    public QuizCommand(String name, String code, String makerName) {
        this.name = name;
        this.code = code;
        this.makerName = makerName;
    }

    public QuizCommand(String name, String code, Date creationDate, String makerName) {
        this.name = name;
        this.code = code;
        this.creationDate = creationDate;
        this.makerName = makerName;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}

    public String getMakerName() {return makerName;}

    public void setMakerName(String makerName) {this.makerName = makerName;}
}
