package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @RequestMapping("/calculator-page")
    public String addtion() {
        return "calculator";
    }


    @RequestMapping("/calculate")

    public String calculator(@ModelAttribute("number1") Integer firstnumber, @ModelAttribute("number2") Integer lastnumber, Model model) throws SQLException {
        model.addAttribute("1stnumber", firstnumber);
        model.addAttribute("2ndnumber", lastnumber);
        int num1 = firstnumber;
        int num2 = lastnumber;
        int sum;

        sum = num1 + num2;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users ( password) values ( ?)");
        statement.setLong(1, sum);
        statement.execute();
        ResultSet resultSet = statement.executeQuery("select * from users order by id desc limit 1");
        while (resultSet.next()) {
            model.addAttribute("id", resultSet.getLong(2));

        }
        return "calculator";
    }

    @RequestMapping("/calculatesub")

    public String calculatorsub(@ModelAttribute("number1") Integer firstnumber, @ModelAttribute("number2") Integer lastnumber, Model model) throws SQLException {
        model.addAttribute("1stnumber", firstnumber);
        model.addAttribute("2ndnumber", lastnumber);
        int num1 = firstnumber;
        int num2 = lastnumber;
        int sub;

        sub = num1 - num2;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users ( password) values ( ?)");
        statement.setLong(1, sub);
        statement.execute();
        ResultSet resultSet = statement.executeQuery("select * from users order by id desc limit 1");
        while (resultSet.next()) {
            model.addAttribute("id1", resultSet.getLong(2));

        }
        return "calculator";
    }
}
