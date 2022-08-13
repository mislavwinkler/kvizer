package hr.tvz.winkler.kvizer;

import hr.tvz.winkler.kvizer.security.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    private Integer id;
    private String name;
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name="maker_Id")
    private User maker;

    @ManyToMany(targetEntity = Question.class, mappedBy = "quizList")
    private List<Question> questionList;

    public Quiz() {  }

    public Quiz(Integer id, String name, Date creationDate, User maker) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.maker = maker;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Date creationDate) {this.creationDate = creationDate;}

    public User getMaker() {return maker;}

    public void setMaker(User maker) {this.maker = maker;}

    public List<Question> getQuestionList() {return questionList;}

    public void setQuestionList(List<Question> questionList) {this.questionList = questionList;}

}
