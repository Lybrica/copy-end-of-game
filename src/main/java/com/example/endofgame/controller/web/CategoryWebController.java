package com.example.endofgame.controller.web;

import com.example.endofgame.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/web")
public class CategoryWebController {

    private static final String CATEGORIES_KEY = "categories";
    private final CategoryService categoryService;

    public CategoryWebController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all-categories")
    public String allCategories(Model model) {
        model.addAttribute(CATEGORIES_KEY, categoryService.readAllCategories());

        return "categories/all-categories";
    }


    @GetMapping("/create-category")
    public String showCategoryForm() {

        return "categories/add-category-page";
    }

    @PostMapping("/save-category")
    public String saveNewCategory(@RequestParam("name") String newCategoryName) {
        log.info("new category name: [{}]", newCategoryName);
        return "redirect:/web/all-categories";
    }


    // delete-category/{id}
    @GetMapping("delete-category/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) {
        log.info("deleting category by id: [{}]", id);

        categoryService.deleteCategoryById(id);

        return "redirect:/web/all-categories";
    }
}
