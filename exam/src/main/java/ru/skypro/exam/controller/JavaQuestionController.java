package ru.skypro.exam.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.exam.model.Question;
import ru.skypro.exam.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Question add(
            @RequestParam String question,
            @RequestParam String answer
    ) {

        return service.add(question, answer);
    }

    @DeleteMapping("/remove")
    public Question remove(
            @RequestParam String question,
            @RequestParam String answer
    ) {

        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {

        return service.getAll();
    }
}