package ru.skypro.exam.service;

import org.springframework.stereotype.Service;
import ru.skypro.exam.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);

        questions.add(newQuestion);

        return newQuestion;
    }

    @Override
    public Question add(Question question) {

        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {

        if (!questions.contains(question)) {
            throw new NoSuchElementException("Вопрос не найден");
        }

        questions.remove(question);

        return question;
    }

    @Override
    public Collection<Question> getAll() {

        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {

        if (questions.isEmpty()) {
            throw new NoSuchElementException("Список вопросов пуст");
        }

        int index = random.nextInt(questions.size());

        return new ArrayList<>(questions).get(index);
    }
}