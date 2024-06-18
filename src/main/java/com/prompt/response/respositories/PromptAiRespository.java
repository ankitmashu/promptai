package com.prompt.response.respositories;

import com.prompt.response.entity.PromptAi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromptAiRespository extends JpaRepository<PromptAi,Long> {
}
