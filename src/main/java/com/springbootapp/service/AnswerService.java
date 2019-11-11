package com.springbootapp.service;

import com.springbootapp.entity.postgres.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAllAnswers();
}
