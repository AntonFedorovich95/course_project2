package pro.sky.course_project2;

import pro.sky.course_project2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
