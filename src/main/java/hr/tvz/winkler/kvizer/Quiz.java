package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.domain.User;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @UniqueElements
    private String code;

    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name="maker_Id")
    private User maker;

    @ManyToMany(targetEntity = Question.class, mappedBy = "quizList")
    private List<Question> questionList;

    public Quiz() {  }

    public Quiz(Integer id, String code, String name, User maker, Date creationDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
        this.maker = maker;
    }

    public Quiz(String code, String name, User maker) {
        this.code = code;
        this.name = name;
        this.creationDate = java.sql.Date.valueOf(LocalDate.now());
        this.maker = maker;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}

    public User getMaker() {return maker;}

    public void setMaker(User maker) {this.maker = maker;}

    public List<Question> getQuestionList() {return questionList;}

    public void setQuestionList(List<Question> questionList) {this.questionList = questionList;}

}
