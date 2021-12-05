package com.example.endofgame.controller;

import com.example.endofgame.dto.CategorySummary;
import com.example.endofgame.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(final CategoryService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    public List<CategorySummary> allCategories() {
        log.info("endpoint: /categories");

        return service.readAllCategories();
    }

    // /categories/1
    // /categories/..
    // /categories/14515444
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategorySummary> findCategoryById(@PathVariable("id") Long myId) {
        log.info("trying to find category with id: [{}]",  myId);

        var readCategorySummary = service.readCategoryById(myId);
        var result = ResponseEntity.notFound().<CategorySummary>build();
        if (readCategorySummary.isPresent()) {
            result = ResponseEntity.ok(readCategorySummary.get());
        }

        return result;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategorySummary> createNewCategory(@RequestBody CategorySummary newCategory) {
        log.info("trying to create new category from request object: [{}]", newCategory);

        var createdCategory = service.createNewCategory(newCategory);
        return ResponseEntity.created(URI.create("/categories/" + createdCategory.id())).body(createdCategory);
    }
}
