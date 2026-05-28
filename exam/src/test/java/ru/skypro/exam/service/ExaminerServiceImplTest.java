package ru.skypro.exam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.skypro.exam.exception.TooManyQuestionsException;
import ru.skypro.exam.model.Question;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {

        questionService = Mockito.mock(QuestionService.class);

        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestionsTest() {

        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        when(questionService.getAll())
                .thenReturn(List.of(q1, q2));

        when(questionService.getRandomQuestion())
                .thenReturn(q1, q2);

        Collection<Question> result =
                examinerService.getQuestions(2);

        assertEquals(2, result.size());
    }

    @Test
    void getQuestionsAmountZeroTest() {

        when(questionService.getAll())
                .thenReturn(List.of(
                        new Question("Q1", "A1")
                ));

        Collection<Question> result =
                examinerService.getQuestions(0);

        assertEquals(0, result.size());
    }

    @Test
    void tooManyQuestionsTest() {

        when(questionService.getAll())
                .thenReturn(List.of(
                        new Question("Q1", "A1")
                ));

        assertThrows(
                TooManyQuestionsException.class,
                () -> examinerService.getQuestions(2)
        );
    }
}