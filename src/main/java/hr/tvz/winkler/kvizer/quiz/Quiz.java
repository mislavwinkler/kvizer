package hr.tvz.winkler.kvizer.quiz;

import hr.tvz.winkler.kvizer.question.Question;
import hr.tvz.winkler.kvizer.security.domain.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name="maker_Id")
    private User maker;

    @OneToMany(mappedBy="quiz",fetch=FetchType.EAGER)
    private List<Question> questionList;

    public Quiz() {  }

    public Quiz(Long id, String code, String name, User maker, Date creationDate) {
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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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
