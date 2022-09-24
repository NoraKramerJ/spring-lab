package com.cydeo.service.impl;

import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import org.springframework.stereotype.Component;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService ShareService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, com.cydeo.service.ShareService shareService) {
        this.recipeRepository = recipeRepository;
        ShareService = shareService;
    }


    @Override
    public boolean prepareRecipe() {

        return false;
    }

    // Break TIME 13:50
}
