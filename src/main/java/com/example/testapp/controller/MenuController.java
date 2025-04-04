package com.example.testapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MenuController {
	
	 // ルートURL ("/") でチーム一覧ページにリダイレクト
    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }
}
