package hr.tvz.winkler.kvizer.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private static final Logger logger = LoggerFactory
            .getLogger(QuestionController.class);

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @Secured({"ROLE_ADMIN"})
    public List<QuestionDTO> getAllQuestion() {
        return questionService.findAll();
    }

    @GetMapping("/{code}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public List<QuestionDTO> getAllQuestionByQuizCode(@PathVariable final String code) {
        return questionService.findAllByQuizCode(code);
    }
    @GetMapping("/id={id}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable final Long id) {
        return questionService.findById(id).map(ResponseEntity::ok).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }
    @PostMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
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
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<QuestionDTO> update(@Valid @RequestBody final QuestionCommand questionCommand){

        return questionService.update(questionCommand.getId(), questionCommand)
                .map(questionDTO -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(questionDTO))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void delete (@PathVariable Long id){
        questionService.delete(id);
    }

    @PostMapping("/upload/{questionId}")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<String> uploadPicture(@PathVariable String questionId, @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                File dir = new File("question-photos");
                if (!dir.exists())
                    dir.mkdirs();

                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + questionId);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                return new ResponseEntity<>("You successfully uploaded file", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("You failed to upload file", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("You failed to upload file because the file was empty", HttpStatus.BAD_REQUEST);
        }
    }
}