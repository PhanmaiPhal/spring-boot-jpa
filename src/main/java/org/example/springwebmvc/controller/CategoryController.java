package org.example.springwebmvc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springwebmvc.dto.CategoryCreateRequest;
import org.example.springwebmvc.dto.CategoryEditRequest;
import org.example.springwebmvc.dto.CategoryResponse;
import org.example.springwebmvc.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

   private final CategoryService categoryService;

   @GetMapping
   @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> findCategories(){
       return categoryService.findCategories();
   }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public CategoryResponse findCategoryById(@PathVariable Integer id){
       return categoryService.findCategoryById(id);
   }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCategory(@Valid  @RequestBody CategoryCreateRequest request){
        categoryService.createNewCategory(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CategoryResponse editCategoryById(@Valid @RequestBody CategoryEditRequest categoryRequest, @PathVariable Integer id){
        return categoryService.editCategoryById(id,categoryRequest);
    }

   @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable Integer id){
       categoryService.deleteCategoryById(id);
   }
}