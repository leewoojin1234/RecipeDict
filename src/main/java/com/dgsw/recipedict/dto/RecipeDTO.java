package com.dgsw.recipedict.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ControllerAdvice
public class RecipeDTO {
    private Long id;
    private String title;
    private String description;
    private List<String> ingredients;
    private List<String> steps;
    private String imageUrl;
}
