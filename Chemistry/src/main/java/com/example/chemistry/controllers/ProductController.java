package com.example.chemistry.controllers;

import com.example.chemistry.repositories.ImageRepository;
import com.example.chemistry.repositories.ProductRepository;
import com.example.chemistry.models.Product;
import com.example.chemistry.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/admin")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/admin/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                 @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/admin";
    }

    @PostMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    @GetMapping("/main")
    public String user(@RequestParam(name = "title", required = false) String title,
                       /*@RequestParam(name = "name", required = false) String name,*/
                       Model model) {
        model.addAttribute("products", productService.listProducts(title));
        /*model.addAttribute("images", productService.listImages(name));*/
        return "mainpage";
    }

    @GetMapping("/main/{id}/")
    public String productPage(@PathVariable Long id, Model model){
        Product product1 = productService.getProductById(id);
        model.addAttribute("product", product1);
        model.addAttribute("images", product1.getImages());
        return "product-info";
    }
    @GetMapping("/")
    public String productPage(Model model){
        return "empty";
    }

    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;



}
