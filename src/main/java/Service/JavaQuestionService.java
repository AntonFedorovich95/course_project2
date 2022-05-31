package Service;

import org.springframework.stereotype.Service;
import pro.sky.course_project2.Exceptions.QuestionNotFoundException;
import pro.sky.course_project2.data.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question a = new Question(question,answer);
        questions.add(a);
        return a;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw new QuestionNotFoundException("Не существующий вопрос. Удаление невозможно.");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        Question [] questionsArr = new Question[questions.size()];
        questions.toArray(questionsArr);
        return questionsArr[random.nextInt(questionsArr.length)];
    }
}
