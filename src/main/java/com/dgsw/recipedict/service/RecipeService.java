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

    public RecipeDTO update(Long id, RecipeDTO dto) {
        RecipeEntity entity = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("레시피 없음"));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setIngredients(dto.getIngredients());
        entity.setSteps(dto.getSteps());
        entity.setImageUrl(dto.getImageUrl());

        return toDTO(recipeRepository.save(entity));
    }

    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }

    private RecipeDTO toDTO(RecipeEntity entity) {
        return RecipeDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .ingredients(entity.getIngredients())
                .steps(entity.getSteps())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
