package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("/category")
    public String category(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        return "category-list";
    }

    @GetMapping("/add-category")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "add-category";
    }

    @PostMapping("/add-category")
    public String add(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công !");
        return "redirect:/category";
    }

    @GetMapping("edit-category/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit-category";
    }

    @PostMapping("edit-category")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveOrUpdate(category);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công !");
        return "redirect:/category";
    }

    @GetMapping("delete/{id}")
    public String block(@PathVariable("id") Integer id, Model model) {
        categoryService.delete(id);
        return "redirect:/category";
    }
}
