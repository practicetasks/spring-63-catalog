package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Category;
import kz.runtime.stat_service.spring63catalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow();
        // merge
        if (category.getName() != null) {
            existingCategory.setName(category.getName());
        }
        categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
