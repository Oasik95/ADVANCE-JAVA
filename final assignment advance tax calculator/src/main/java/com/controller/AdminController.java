package com.controller;



import com.domain.Authority;
import com.domain.TaxUser;
import com.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {



    private TaxUserService taxUserService;

    public AdminController(TaxUserService taxUserService) {
        this.taxUserService = taxUserService;

    }


//    @RequestMapping("/home")
//    public String HOME() {
//        return "adminhome";
//    }

    @RequestMapping("/home")
    public String userlist(Model model) {

        List<TaxUser> all = taxUserService.getAll();
        model.addAttribute("historyList",all);
        return "adminhome";
    }


}
