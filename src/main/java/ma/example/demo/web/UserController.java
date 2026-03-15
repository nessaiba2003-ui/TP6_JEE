package ma.example.demo.web;

import jakarta.validation.Valid;
import ma.example.demo.entities.User;
import ma.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. AFFICHER LA LISTE (Page d'accueil)
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    // 2. FORMULAIRE D'AJOUT (Signup)
    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    // 3. ENREGISTRER UN NOUVEL UTILISATEUR
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);
        return "redirect:/index";
    }

    // 4. AFFICHER LE FORMULAIRE DE MODIFICATION (Edit)
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "update-user";
    }

    // 5. ENREGISTRER LA MODIFICATION (Update)
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id); // On garde l'ID pour ne pas le perdre en cas d'erreur
            return "update-user";
        }
        userRepository.save(user);
        return "redirect:/index";
    }

    // 6. SUPPRIMER UN UTILISATEUR
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }
}
