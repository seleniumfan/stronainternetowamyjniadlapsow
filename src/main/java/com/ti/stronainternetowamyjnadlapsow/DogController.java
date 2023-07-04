package com.ti.stronainternetowamyjnadlapsow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DogController {
    private final MailService mailService;

    public DogController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/jak_to_dziala")
    public String howItWork() {
        return "how_it_work";
    }

    @GetMapping("kontakt")
    public String contact() {
        return "contact";
    }

    @PostMapping("/send_message")
    public String sendMessage(@ModelAttribute Mail mail,
                              Model model) {
        mailService.sendMail(mail);
        mailService.sendConfirmation(mail);
        model.addAttribute("email", mail.getEmail());
        return "message_sent";
    }
}
