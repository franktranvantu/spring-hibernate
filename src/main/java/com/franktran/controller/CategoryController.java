package com.franktran.controller;

import com.franktran.data.CategoryRepository;
import com.franktran.data.GifRepository;
import com.franktran.model.Category;
import com.franktran.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
