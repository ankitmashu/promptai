package com.prompt.response.controller;

import com.prompt.response.entity.PromptAi;
import com.prompt.response.services.PromptService;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prompt")
public class PromptController {

    private OllamaChatClient client;
    private PromptService promptService;
    private PromptAi promptAi;
    String response;

    public PromptController(OllamaChatClient client, PromptAi promptAi, PromptService promptService) {
        this.client = client;
        this.promptAi = promptAi;
        this.promptService = promptService;
    }

    @PostMapping("/save")
    public String savePrompt(@RequestParam("prompt") String prompt) {
        response = client.call(prompt);
        promptAi = new PromptAi(prompt,response);
       // return
        System.out.println("Prompt created successfully with response " + response);
        promptService.create(promptAi);
        return response;
    }

    @GetMapping("/directresponse")
    public String promptResponse(@RequestParam("prompt") String prompt) {
        response = client.call(prompt);
        return response;
    }

    @GetMapping()
    public List<PromptAi> getAll() {
        return promptService.get();
    }

    @GetMapping("/{promptId}")
    public PromptAi getId(@PathVariable Long promptId) {
        return promptService.getOne(promptId);
    }
    /*@GetMapping("/allprompt")
    public List<PromptAi> getAllPrompt() {
        return promptService.getAllPrompt();
    }*/
}
