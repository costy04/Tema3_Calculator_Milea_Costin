package com.api.calculator.Controllers;

import com.api.calculator.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ResultController {
    @GetMapping("/results")
    public String showTable(@RequestParam("filename") String fileName, Model model) {
        List<String> results = Utils.readFromFile(fileName);
        model.addAttribute("results", results);
        return "results";
    }

}