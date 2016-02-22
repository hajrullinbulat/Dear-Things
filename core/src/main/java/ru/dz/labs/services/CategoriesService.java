package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Categories;
import ru.dz.labs.repository.CategoriesRepository;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Transactional
    public void addCategories(Categories categories){
        categoriesRepository.add(categories);
    }
}
