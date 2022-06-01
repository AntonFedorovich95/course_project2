package pro.sky.course_project2.service;

import org.springframework.stereotype.Service;
import pro.sky.course_project2.exceptions.QuestionArrayListIndexOutOfBoundsException;
import pro.sky.course_project2.data.Question;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new QuestionArrayListIndexOutOfBoundsException();
        }
        Collection<Question> randomQuestionList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            boolean isTrue = true;
            while (isTrue) {
                Question q = questionService.getRandomQuestion();
                if (!randomQuestionList.contains(q)) {
                    randomQuestionList.add(q);
                    isTrue = false;
                }
            }
        }
        return randomQuestionList;
    }
}