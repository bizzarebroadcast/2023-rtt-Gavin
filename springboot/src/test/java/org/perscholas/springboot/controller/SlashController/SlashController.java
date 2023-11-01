package org.perscholas.springboot.controller.SlashController;

import org.springframework.stereotype.Controller;

@Controller
public class SlashController {
    public void index(){
        User user = new User();

        user.setId(1);
        user.setUsername("eric@webworkbennch.net");
    }
}
