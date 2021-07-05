package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.security.UserService;


@Controller
public class LoginController {

    // login page warrning invalid credentials change
    @GetMapping("/login")
    public String loginFormShow() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String logoutForm() {
        return "index";
    }

}
