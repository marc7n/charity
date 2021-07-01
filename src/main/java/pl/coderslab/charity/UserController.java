package pl.coderslab.charity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.security.CurrentUser;
import pl.coderslab.charity.security.UserService;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new-user")
    @ResponseBody
    public String newUser() {
        User user = new User();
        user.setUsername("ADMIN");
        user.setEmail("admin@donation.com.pl");
        user.setPassword("admin");
        userService.addUser(user);
        return "admin";
    }

    @GetMapping("/logged-user")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }

    @GetMapping("/register")
    public String registerFormShow(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerFormPerform(@Valid User user, BindingResult bindingResult) {

        boolean userNameExists = userService.existsByName(user.getUsername());
        boolean userEmailExists = userService.existsByEmail(user.getEmail());

        if (!user.getPassword().equals(user.getPassword2())) {
            bindingResult
                    .rejectValue("password2", "error.user",
                            "Password and password2 are different");
            bindingResult
                    .rejectValue("password", "error.user",
                            "Password and password2 are different");
            user.setPassword("");
            user.setPassword2("");
        }
        if (userNameExists) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is a user registered with the user name provided");
        }
        if (userEmailExists) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.addUser(user);

        return "redirect:/login";
    }
}