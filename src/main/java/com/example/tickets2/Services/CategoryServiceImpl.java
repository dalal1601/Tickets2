package com.example.tickets2.Services;

import com.example.tickets2.Entities.Category;
import com.example.tickets2.Repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = null;
        try {
            categoryUpdate= categoryRepository.findById(category.getId()).get();
            categoryUpdate.setCategoryName(category.getCategoryName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return categoryRepository.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

}
