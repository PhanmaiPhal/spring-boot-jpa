package org.example.springwebmvc.repository;

import org.example.springwebmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);

}
