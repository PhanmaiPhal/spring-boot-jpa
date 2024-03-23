package org.example.springwebmvc.service;

import jakarta.validation.Valid;
import org.example.springwebmvc.dto.CategoryCreateRequest;
import org.example.springwebmvc.dto.CategoryEditRequest;
import org.example.springwebmvc.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

   List<CategoryResponse> findCategories();

   CategoryResponse findCategoryById(Integer id);

   CategoryResponse findCategoryByName(String name);

    void createNewCategory(CategoryCreateRequest request);
   CategoryResponse editCategoryById(Integer id, CategoryEditRequest categoryRequest);

   void deleteCategoryById(Integer id);
}
