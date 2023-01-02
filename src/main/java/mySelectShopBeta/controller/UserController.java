package mySelectShopBeta.controller;

import lombok.RequiredArgsConstructor;
import mySelectShopBeta.Dto.LoginRequestDto;
import mySelectShopBeta.Dto.SignupRequestDto;
import mySelectShopBeta.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public ModelAndView signupPage() {
        return new ModelAndView("MyselectShop_signup");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("MyselectShop_login");
    }

    @PostMapping("/signup")
    public String signup(SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }

}