package kz.runtime.stat_service.spring63catalog.controller;

import kz.runtime.stat_service.spring63catalog.model.Product;
import kz.runtime.stat_service.spring63catalog.service.CategoryService;
import kz.runtime.stat_service.spring63catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
// localhost:8080/products/{prodId}
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("{productId}")
    public String findById(
            @PathVariable long productId,
            Model model
    ) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        return "product_single_page";
    }

    // http://localhost:8080/products/create
    @GetMapping("/create/chooseCategory")
    public String chooseCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "choose_category_for_product";
    }

    // http://localhost:8080/products/create?categoryId=1
    @GetMapping("/create")
    public String showForm(Model model, @RequestParam(required = false) Long categoryId) {
        if (categoryId == null) {
            return "redirect:/products/create/chooseCategory";
        }
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryService.findById(categoryId));
        return "product_create";
    }

    @GetMapping("/update/{productId}")
    public String updateForm(Model model, @PathVariable long productId) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        model.addAttribute("options", categoryService.findOptionsByCategoryId(product.getCategory().getId()));
        model.addAttribute("values", product.getValues());
        return "product_update";
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute Product product,
            @RequestParam Long categoryId,
            @RequestParam List<String> valueNames,
            @RequestParam List<Long> optionIds
    ) {
        productService.create(product, categoryId, optionIds, valueNames);
        return "redirect:/products";
    }

    @PostMapping("/update/{productId}")
    public String update(
            @PathVariable long productId,
            @RequestParam String updatedName,
            @RequestParam double updatedPrice,
            @RequestParam List<String> valueNames,
            @RequestParam List<Long> optionIds
    ) {
        productService.update(productId, updatedName, updatedPrice, optionIds, valueNames);
        return "redirect:/products";
    }

    @GetMapping("/delete/{productId}")
    public String deleteById(@PathVariable long productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }
}
