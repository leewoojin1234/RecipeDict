package com.dgsw.recipedict.controller;

import com.dgsw.recipedict.dto.RecipeDTO;
import com.dgsw.recipedict.dto.ResponseDTO;
import com.dgsw.recipedict.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @PostMapping
    public ResponseDTO create(@RequestBody @Valid RecipeDTO dto) {
        log.info("레시피 등록 요청: {}", dto.getTitle());
        recipeService.create(dto);
        return new ResponseDTO("created");
    }

    @PutMapping("/recipe")
    public ResponseDTO update(@RequestBody @Valid RecipeDTO dto) {
        log.info("레시피 수정 요청: {}", dto.getId());
        boolean updated = recipeService.updateRecipe(dto);
        return new ResponseDTO(updated ? "updated" : "not found");
    }

    @DeleteMapping("/recipe")
    public ResponseDTO delete(@RequestParam("id") Long id) {
        log.info("레시피 삭제 요청: {}", id);
        boolean deleted = recipeService.deleteRecipe(id);
        return new ResponseDTO(deleted ? "deleted" : "not found");
    }

    @GetMapping("/recipeCards")
    public List<RecipeDTO> GetRecipeCards(){
        return recipeService.getRecipeCards();
    }

    @GetMapping("/getRecipeDetails")
    public RecipeDTO GetRecipeDetails(long recipeId){
        return recipeService.getRecipeDetails(recipeId);
    }
}
