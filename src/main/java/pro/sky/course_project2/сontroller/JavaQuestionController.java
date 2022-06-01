package pro.sky.course_project2.сontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_project2.service.QuestionService;
import pro.sky.course_project2.data.Question;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
    Question q = new Question(question,answer);
    return service.add(q);
    }
}
