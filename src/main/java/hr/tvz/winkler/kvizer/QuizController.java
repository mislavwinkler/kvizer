package hr.tvz.winkler.kvizer;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
//@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {this.quizService = quizService;}

    @GetMapping
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<QuizDTO> getAllQuiz(){
        return quizService.findAll();
    }
}
