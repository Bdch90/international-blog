package codegym.blog.controller;

import codegym.blog.request.Credential;
import codegym.blog.response.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController
{
    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("credential") Credential credential)
    {
        ModelAndView modelAndView = new ModelAndView("/blog");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView dashboard(@ModelAttribute("credential") Credential credential)
    {
        User user = new User();
        user.setUserName(credential.getUsername());
        ModelAndView modelAndView = new ModelAndView("/dashboard");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
}
