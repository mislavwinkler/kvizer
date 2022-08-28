package hr.tvz.winkler.kvizer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {this.quizService = quizService;}

    @GetMapping
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<QuizDTO> getAllQuiz(){
        return quizService.findAll();
    }


    @GetMapping("/{code}")
//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<QuizDTO> getQuizByCode(@PathVariable final String code){
        return quizService.findByCode(code).map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

    @PostMapping
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<QuizDTO> save(@Valid @RequestBody final QuizCommand quizCommand){
        return quizService.save(quizCommand)
                .map(quizDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(quizDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
//    @Secured({"ROLE_ADMIN"})
    public void delete (@PathVariable String code){
        quizService.delete(code);
    }

    @PutMapping("/{code}")
//    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<QuizDTO> update(@PathVariable String code,
                                              @Valid @RequestBody final QuizCommand quizCommand){

        return quizService.update(code, quizCommand).map(quizDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(quizDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );

    }
}
