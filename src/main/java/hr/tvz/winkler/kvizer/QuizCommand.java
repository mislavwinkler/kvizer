package hr.tvz.winkler.kvizer;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class QuizCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Quiz must have a code")
    private String code;

//    @NotBlank(message = "Date od creation is mandatory")
//    private Date creationDate;

    @NotNull(message = "Quiz must have a maker")
    private Long makerId;

    public QuizCommand(String name, String code, /*Date creationDate,*/ Long makerId) {
        this.name = name;
        this.code = code;
//        this.creationDate = creationDate;
        this.makerId = makerId;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

//    public Date getCreationDate() {return creationDate;}
//
//    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}

    public Long getMakerId() {return makerId;}

    public void setMakerId(Long makerId) {this.makerId = makerId;}
}
