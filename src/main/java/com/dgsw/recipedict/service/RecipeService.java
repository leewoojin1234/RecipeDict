package com.dgsw.recipedict.service;

import com.dgsw.recipedict.dto.RecipeDTO;
import com.dgsw.recipedict.entity.RecipeEntity;
import com.dgsw.recipedict.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public boolean create(RecipeDTO dto) {
        try {
            RecipeEntity entity = RecipeEntity.builder()
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .ingredients(dto.getIngredients())
                    .steps(dto.getSteps())
                    .imageUrl(dto.getImageUrl())
                    .build();

            recipeRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRecipe(RecipeDTO dto) {
        Optional<RecipeEntity> optional = recipeRepository.findById(dto.getId());
        if (optional.isPresent()) {
            RecipeEntity entity = optional.get();
            entity.setTitle(dto.getTitle());
            entity.setDescription(dto.getDescription());
            entity.setIngredients(dto.getIngredients());
            entity.setSteps(dto.getSteps());
            entity.setImageUrl(dto.getImageUrl());
            recipeRepository.save(entity);
            return true;
        }
        return false;
    }

    public boolean deleteRecipe(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
