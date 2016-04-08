package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Categories;
import ru.dz.labs.repository.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public void addCategories(Categories categories) {
        categoriesRepository.add(categories);
    }

    @Transactional
    public Categories getCategoryById(Long id) {
        return categoriesRepository.getCategoryById(id);
    }

    @Transactional
    public List getMainCategories() {
        return categoriesRepository.getMainCategories();
    }

    @Transactional
    public List getAllCategories() {
        return categoriesRepository.getAllCategories();
    }

}
