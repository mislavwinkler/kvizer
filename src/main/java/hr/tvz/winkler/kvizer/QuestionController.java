package hr.tvz.winkler.kvizer;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<QuestionDTO> getAllQuestion() {
        return questionService.findAll();
    }

    @GetMapping("/{code}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<QuestionDTO> getAllQuestionByQuizCode(@PathVariable final String code) {
        return questionService.findAllByQuizCode(code);
    }
}
