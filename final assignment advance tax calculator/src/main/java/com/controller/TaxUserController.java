package com.controller;

import com.domain.*;

import com.service.*;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entrepreneur")
public class TaxUserController {

    private TaxUserService taxUserService;
    private UserService userService;

    private AuthorityService authorityService;
    private TaxService taxService;
    private TaxResultService taxResultService;




    public TaxUserController(TaxUserService taxUserService, UserService userService, AuthorityService authorityService, TaxService taxService, TaxResultService taxResultService) {
        this.taxUserService = taxUserService;
        this.userService = userService;
        this.authorityService = authorityService;
        this.taxService = taxService;
        this.taxResultService =taxResultService ;

    }





    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home(Principal principal,Model model) {
        TaxUser taxUser= taxUserService.findByUserName(principal.getName());
        model.addAttribute("id",taxUser.getId());
        return "taxUserHome";
    }




    @RequestMapping("/show")
    public String show(Model model) {
        TaxUser taxUser = new TaxUser();
        model.addAttribute("taxUser", taxUser);
        return "register";
    }



    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute("taxUser") TaxUser taxUser,
                         @ModelAttribute("user")User user ,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "register";
        } else {

            taxUserService.insert(taxUser);


            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(authorityService.get(2L));
            user.setAuthorities(authorityList);
            userService.insert(user);
            return "login";
        }
    }






    @RequestMapping("/input")
    public String submitida(@Valid @ModelAttribute("tax") Tax tax  ,Model model,

                            BindingResult bindingResult, Principal principal) throws SQLException {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "taxUserHome";
        }
        else {
            TaxUser taxUser= taxUserService.findByUserName(principal.getName());
            tax.setUser(taxUser);
            taxService.insert(tax);
            TaxResult taxResult = taxService.calculateTax(tax);
            taxResult.setUser(taxUser);
            taxResultService.insert(taxResult);
            model.addAttribute("taxResult",taxResult);
            return "ViewResult";
        }
    }

    @RequestMapping("/ideahistory")
    public String getAll(Principal principal, Model model) {

        List<Tax> all = taxService.getAllByUserName(principal.getName());
        List<TaxResult> all1 = taxResultService.getAllByUserName(principal.getName());
        model.addAttribute("historyList",all);
        model.addAttribute("resultList",all1);


        return "history";
    }

    @RequestMapping("/resetpass")
    public String resetpass(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {

            return "forgotpass";

        } else {
            User user1 = userService.getByUsername(user.getUsername());
            if(user!=null)
            {
                user1.setPassword(user.getPassword());

                userService.update(user1);

            }
            return "login";
        }
    }








}

