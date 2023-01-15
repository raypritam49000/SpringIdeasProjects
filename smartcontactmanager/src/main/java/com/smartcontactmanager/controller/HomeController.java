package com.smartcontactmanager.controller;

import com.smartcontactmanager.helper.Message;
import com.smartcontactmanager.models.User;
import com.smartcontactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")
    public String test(Model model) {
        model.addAttribute("title", "Home - Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About - Smart Contact Manager");
        return "about";
    }

    @RequestMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("title", "Register - Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    //register user
    @RequestMapping(path = "/do_register",method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
                               @RequestParam(value = "agreement",defaultValue = "false") Boolean agreement, Model model,
                               HttpSession session ) {
        try
        {
            if(!agreement){
                System.out.println("You have not accepts terms and conditions");
                throw new Exception("You have not accepts terms and conditions");
            }

            if(result.hasErrors()){
                System.out.println("Error : "+result.toString());
                model.addAttribute("user",user);
                return "signup";
            }

            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            User result1  = this.userService.saveUser(user);

            System.out.println("User : "+user);
            System.out.println("Agreement : "+agreement);
            model.addAttribute("user",new User());
            session.setAttribute("message",new Message("Successfully Registered !!!","alert-success"));
        }
        catch (Exception e)
        {
          e.printStackTrace();
          model.addAttribute("user",user);
          session.setAttribute("message",new Message("Something Went Wrong!!!"+e.getMessage(),"alert-danger"));
        }
        return "signup";
    }


    // handler for custom login
    @RequestMapping("/signin")
    public String customLogin(Model model){
        model.addAttribute("title","Login - Smart Contact Manager");
        return "login";
    }

}
