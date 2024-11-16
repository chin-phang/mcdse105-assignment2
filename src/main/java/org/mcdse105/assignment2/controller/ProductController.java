package org.mcdse105.assignment2.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mcdse105.assignment2.entity.Product;
import org.mcdse105.assignment2.exception.DuplicateProductException;
import org.mcdse105.assignment2.exception.InvalidNameProductException;
import org.mcdse105.assignment2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getProductsPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/new")
    public String getNewProductPage() {
        return "product-new";
    }

    @PostMapping("/products/new")
    public RedirectView AddNewProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView ("/products");
        Product savedProduct = productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("savedProduct", savedProduct);
        redirectAttributes.addFlashAttribute("addProductSuccess", true);
        return redirectView;
    }

    @GetMapping("/products/{id}")
    public String getProductPage(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/products/{id}/update")
    public String updateProduct(Model model, @ModelAttribute("product") Product product,
                                @PathVariable("id") Long id) {
        productService.updateProductDetails(id, product);
        model.addAttribute("msg", "Product updated successfully.");
        return "product";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.removeProductById(id);
        return "redirect:/products";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DuplicateProductException.class)
    public ModelAndView handleDuplicateProductException(HttpServletRequest req, DuplicateProductException ex) {
        log.error("Error: {}", ex.getMessage());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg", ex.getMessage());
        modelAndView.addObject("product", req.getAttribute("product"));
        modelAndView.setViewName("product-new");
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = InvalidNameProductException.class)
    public ModelAndView handleInvalidNameProductException(HttpServletRequest req, InvalidNameProductException ex) {
        log.error("Error: {}", ex.getMessage());

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg", ex.getMessage());
        modelAndView.addObject("product", req.getAttribute("product"));
        modelAndView.setViewName("product-new");
        return modelAndView;
    }
}
