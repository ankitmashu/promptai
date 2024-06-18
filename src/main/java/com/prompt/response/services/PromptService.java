package com.prompt.response.services;

import com.prompt.response.entity.PromptAi;


import java.util.List;

public interface PromptService {
    PromptAi create(PromptAi promptSave);

    List<PromptAi> get();

    PromptAi getOne(Long id);

    /*List<PromptAi> getAllPrompt();*/
}
