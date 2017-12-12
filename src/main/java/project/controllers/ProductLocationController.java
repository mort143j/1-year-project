package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import project.models.entities.Location;
import project.models.entities.Product;
import project.models.entities.ProductLocation;
import project.models.repositories.LocationRepository;
import project.models.repositories.ProductLocationRepository;
import project.models.repositories.ProductRepository;

import java.util.List;


@Controller
public class ProductLocationController {

    @Autowired
    ProductLocationRepository productLocationRepository = new ProductLocationRepository();

    @Autowired
    ProductRepository productRepository = new ProductRepository();

    @Autowired
    LocationRepository locationRepository = new LocationRepository();


    @GetMapping("/productLocation")
    public String productLocation(Model model){
        List products = productRepository.listProducts();
        List locations = locationRepository.listLocation();

        model.addAttribute("products", products);
        model.addAttribute("locations", locations);
        return "productLocation";
    }

    @PostMapping("/productLocation")
    public String productLocation(@RequestParam("productID") int productID, @RequestParam("locationID") int locationID, @RequestParam("stock") int stock){
        ProductLocation productLocation = new ProductLocation();
        productLocation.setProductFK(productID);
        productLocation.setLocationFK(locationID);
        productLocation.setStock(stock);

        productLocationRepository.createProductLocation(productLocation);
        return "redirect:/profile";
    }
    @GetMapping("storageDisplay")
    public String storageDisplay(){

        return "storageDisplay";
    }
}
