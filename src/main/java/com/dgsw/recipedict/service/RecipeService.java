package com.dgsw.recipedict.service;

import com.dgsw.recipedict.dto.RecipeDTO;
import com.dgsw.recipedict.entity.RecipeEntity;
import com.dgsw.recipedict.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }
}
