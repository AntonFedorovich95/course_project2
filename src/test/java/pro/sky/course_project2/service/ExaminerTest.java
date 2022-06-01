package pro.sky.course_project2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_project2.data.Question;

import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;
import static pro.sky.course_project2.constants.ConstantsTest.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerTest {

    @Mock
    private QuestionService questionsMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test public void shouldReturnAnyListWhenCallGetQuestionsMethod() {
        Collection<Question> questionList = List.of(new Question(DEFAULT_QUESTION_TEXT,DEFAULT_ANSWER_TEXT));
        when(questionsMock.getAll()).thenReturn(questionList);
        when(questionsMock.getRandomQuestion()).thenReturn(new Question(DEFAULT_QUESTION_TEXT,DEFAULT_ANSWER_TEXT));
        Assertions.assertEquals(questionList, out.getQuestions(1));
}
}