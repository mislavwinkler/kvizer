package hr.tvz.winkler.kvizer.security.user.answer;

import hr.tvz.winkler.kvizer.security.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    @Secured({"ROLE_ADMIN"})
    public List<AnswerDTO> getAllAnswers() {
        return answerService.findAll();
    }

    @GetMapping("/quiz={quizCode}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<UserDTO> getAllUsersByQuizCode(@PathVariable final String quizCode) {
        return answerService.findUsersByQuizCode(quizCode);
    }

    @GetMapping("/{questionId}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<AnswerDTO> getAnswersByQuestionId(@PathVariable final Long questionId) {
        return answerService.findAllByQuestionId(questionId);
    }
    @GetMapping("/{quizCode}/{username}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<AnswerDTO> getAnswersByQuizCodeAndUsername(@PathVariable final String quizCode, @PathVariable final String username) {
        return answerService.findAllByQuizCodeAndUsername(quizCode, username);
    }
    @GetMapping("/id={id}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable final Long id) {
        return answerService.findById(id).map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }
    @PostMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
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
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
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
