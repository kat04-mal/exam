package ru.skypro.exam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.exam.model.Question;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void addStringTest() {

        Question expected = new Question("Q1", "A1");

        Question actual = service.add("Q1", "A1");

        assertEquals(expected, actual);
    }

    @Test
    void addQuestionTest() {

        Question question = new Question("Q1", "A1");

        Question actual = service.add(question);

        assertEquals(question, actual);
    }

    @Test
    void removeTest() {

        Question question = new Question("Q1", "A1");

        service.add(question);

        service.remove(question);

        assertFalse(service.getAll().contains(question));
    }

    @Test
    void removeFromEmptyCollectionTest() {

        Question question = new Question("Q1", "A1");

        assertThrows(
                NoSuchElementException.class,
                () -> service.remove(question)
        );
    }

    @Test
    void getAllTest() {

        service.add("Q1", "A1");
        service.add("Q2", "A2");

        Collection<Question> questions = service.getAll();

        assertEquals(2, questions.size());
    }

    @Test
    void getRandomQuestionTest() {

        Question question = new Question("Q1", "A1");

        service.add(question);

        Question actual = service.getRandomQuestion();

        assertEquals(question, actual);
    }

    @Test
    void getRandomQuestionEmptyTest() {

        assertThrows(
                NoSuchElementException.class,
                () -> service.getRandomQuestion()
        );
    }

    @Test
    void duplicateTest() {

        service.add("Q1", "A1");
        service.add("Q1", "A1");

        assertEquals(1, service.getAll().size());
    }
}