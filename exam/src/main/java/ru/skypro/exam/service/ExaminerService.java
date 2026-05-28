package ru.skypro.exam.service;

import ru.skypro.exam.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}