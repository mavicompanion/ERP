package com.ERP.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERP.v1.repository.CategoryRepository;

import com.ERP.v1.model.Category;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategoriesByEnterprise(String domain)
    {
        List<Category> categories = new ArrayList<>();

        List<Category> allCategories = categoryRepository.findAll();

        for(Category category : allCategories)
        {
            if (category.getEnterprise().getDomain().equals(domain))
            {
                categories.add(category);
            }
        }

        return categories;
    }

}
