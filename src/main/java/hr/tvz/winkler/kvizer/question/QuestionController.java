package hr.tvz.winkler.kvizer.question;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/id={id}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable final Long id) {
        return questionService.findById(id).map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }
    @PostMapping
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<QuestionDTO> save(@Valid @RequestBody final QuestionCommand questionCommand){
        return questionService.save(questionCommand)
                .map(quizDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(quizDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @PutMapping
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<QuestionDTO> update(@Valid @RequestBody final QuestionCommand questionCommand){

        return questionService.update(questionCommand.getId(), questionCommand)
                .map(questionDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(questionDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );

    }
}