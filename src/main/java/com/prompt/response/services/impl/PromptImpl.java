package com.prompt.response.services.impl;

import com.prompt.response.entity.PromptAi;
import com.prompt.response.respositories.PromptAiRespository;
import com.prompt.response.services.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromptImpl implements PromptService {

    @Autowired
    private PromptAiRespository promptAiRespository;

    @Override
    public PromptAi create(PromptAi promptAiQuestion) {
        return promptAiRespository.save(promptAiQuestion);
    }

    @Override
    public List<PromptAi> get() {
        return promptAiRespository.findAll();
    }

    @Override
    public PromptAi getOne(Long id) {
        return promptAiRespository.findById(id).orElseThrow(()->new RuntimeException("Prompt id not found"));
    }

    /*@Override
    public List<PromptAi> getAllPrompt() {
        return promptAiRespository.findByprompt();
    }*/
}
