package ru.skypro.exam.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.exam.model.Question;
import ru.skypro.exam.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(
            @PathVariable int amount
    ) {

        return examinerService.getQuestions(amount);
    }
}