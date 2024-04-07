package com.example.tickets2.Services;

import com.example.tickets2.Entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(Long id);
    Category update(Category category);
    void deleteById(Long id);



    public List<Category> getCategory();

}
