package hr.tvz.winkler.kvizer.answer;

import hr.tvz.winkler.kvizer.question.QuestionCommand;
import hr.tvz.winkler.kvizer.question.QuestionDTO;
import hr.tvz.winkler.kvizer.question.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("answer")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<AnswerDTO> getAllAnswers() {
        return answerService.findAll();
    }

    @GetMapping("/{questionId}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<AnswerDTO> getAnswersByQuestionId(@PathVariable final Long questionId) {
        return answerService.findAllByQuestionId(questionId);
    }
    @GetMapping("/id={id}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable final Long id) {
        return answerService.findById(id).map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }
    @GetMapping("/user={username}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<AnswerDTO> getAnswersByUserId(@PathVariable final String username) {
        return answerService.findAllByUserUsername(username);
    }
    @PostMapping
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<AnswerDTO> save(@Valid @RequestBody final AnswerCommand answerCommand){
        return answerService.save(answerCommand)
                .map(AnswerDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(AnswerDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @PutMapping
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<AnswerDTO> update(@Valid @RequestBody final AnswerCommand answerCommand){

        return answerService.update(answerCommand.getId(), answerCommand)
                .map(AnswerDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(AnswerDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );

    }
}
