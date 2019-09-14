package am.itspace.recaptchaexamplewithh2.controller;

import am.itspace.recaptchaexamplewithh2.dto.CaptchaDto;
import am.itspace.recaptchaexamplewithh2.model.Player;
import am.itspace.recaptchaexamplewithh2.repository.PlayerRepository;
import am.itspace.recaptchaexamplewithh2.util.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {

    private final CaptchaUtil captchaUtil;
    private final PlayerRepository playerRepository;

    public MainController(CaptchaUtil captchaUtil, PlayerRepository playerRepository) {
        this.captchaUtil = captchaUtil;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@Valid Player player, ModelMap map, @RequestParam("g-recaptcha-response") String response){
        CaptchaDto captcha = captchaUtil.getCaptcha(response);
        if (captcha.isSuccess()){
            playerRepository.save(player);
            map.addAttribute("message", "Player added successfully!");
            return "index";
        } else {
            map.addAttribute("errorMessage","Captcha Error! Try again!");
            return "index";
        }

    }
}
