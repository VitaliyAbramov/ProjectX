package com.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootapp.entity.postgres.Answer;
import com.springbootapp.repository.AnswerRepository;
import com.springbootapp.service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAllBy();
    }
}
