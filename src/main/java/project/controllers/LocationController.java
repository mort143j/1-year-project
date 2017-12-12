package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.models.entities.Location;
import project.models.repositories.LocationRepository;

import java.util.List;


@Controller
public class LocationController {

    @Autowired
    LocationRepository locationRepository = new LocationRepository();

    @GetMapping("/newLocation")
    public String newLocation(Model model){
        model.addAttribute("location", new Location());
        return "newLocation";
    }
    @PostMapping("/newLocation")
    public String newLocation(@ModelAttribute Location location){
        locationRepository.createLocation(location);
        return "redirect:/profile";
    }
    @GetMapping("/locations")
    public String locations(Model model){
        List locations = locationRepository.listLocation();
        model.addAttribute("locations", locations);
        return "locations";
    }
    @GetMapping("updateLocation")
    public String updateLocation(@RequestParam("locationID") int locationID, Model model){
        model.addAttribute(locationRepository.readLocation(locationID));
        return "updateLocation";
    }
    @PostMapping("updateLocation")
    public String updateLocation(@ModelAttribute Location location){
        locationRepository.updateLocation(location, location.getLocationID());
        return "redirect:/profile";
    }
}
