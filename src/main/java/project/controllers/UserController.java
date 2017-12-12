package project.controllers;

import project.models.entities.User;
import project.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;

@Controller
public class UserController {
    HashMap<String, User> users = new HashMap();

    @Autowired
    UserRepository userRepository = new UserRepository();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/update")
    public String update(Model model){
        String ID = RequestContextHolder.currentRequestAttributes().getSessionId();
        User user = this.users.get(ID);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user){
        userRepository.update(user);
        return "redirect:/profile";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user){
        User member = userRepository.login(user);
        if(member.getName() == null && member.getPassword() == null) {
            return "redirect:/fail";
        }
        users.put(RequestContextHolder.currentRequestAttributes().getSessionId(),member);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute(users.get(RequestContextHolder.currentRequestAttributes().getSessionId()));
        return "profile";
    }
    @PostMapping("/profile")
    public String profile(){
        return "profile";
    }
    @GetMapping("/fail")
    public String fail(){
        return "fail";
    }
}
