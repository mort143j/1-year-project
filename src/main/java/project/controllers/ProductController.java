package project.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import project.models.entities.Product;
import project.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository = new ProductRepository();

    @GetMapping("/newProduct")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "newProduct";
    }
    @PostMapping("/newProduct")
    public String newProduct(@ModelAttribute Product product){
        productRepository.createProduct(product);
        return "redirect:/profile";
    }
    @GetMapping("/products")
    public String products(Model model) {
        List products = productRepository.listProducts();
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("productID") int productID, Model model){
        model.addAttribute(productRepository.readProduct(productID));
        return "updateProduct";
    }
    @PostMapping("/updateProduct")
        public String updateProduct(@ModelAttribute Product product){
        productRepository.updateProduct(product, product.getProductID());
        return "redirect:/profile";

    }
}
