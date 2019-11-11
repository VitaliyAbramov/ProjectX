package com.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootapp.entity.postgres.Answer;
import com.springbootapp.service.AnswerService;

import java.util.List;

@RestController
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers")
    public List<Answer> getUsers() {
        return answerService.getAllAnswers();
    }
}
