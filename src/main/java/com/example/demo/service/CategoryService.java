package com.example.demo.service;

import java.util.*;
import com.example.demo.model.Category;

public interface CategoryService {
    public Category saveCategory(Category category);

    public Boolean exitsCategory(String name);

    public List<Category> getAllCategory();

}
