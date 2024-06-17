package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "index";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "show-user";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id", defaultValue = "0") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "/edit";
    }

    @PatchMapping()
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping()
    public String deleteUser(@RequestParam(value = "id", defaultValue = "0") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}