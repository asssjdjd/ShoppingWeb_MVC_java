package com.example.demo.Controllers;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin")
public class AdminControllers {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"", "/"})
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddProduct")
    public String loadAddProduct(){
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category(){
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file, HttpSession session){

        String imageName = file != null ? file.getOriginalFilename() : "default.jpg";
        category.setImageName(imageName);

        Boolean exitsCategory = categoryService.exitsCategory(category.getName());

        if(exitsCategory) {
            session.setAttribute("errorMsg","Category Name already exits");
        }else{
            com.example.demo.model.Category saveCategory = categoryService.saveCategory(category);

            if (ObjectUtils.isEmpty(saveCategory)) {
                session.setAttribute("errorMsg", "Error saving category");
            } else {
                session.setAttribute("succMsg", "Category saved successfully");
            }
        }

        return "redirect:/admin/category";
    }


}
