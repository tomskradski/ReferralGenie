package com.radar.Controllers;

import com.radar.Models.ReferredPractice;
import com.radar.Services.ReferredPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PracticeController {

    @Autowired
    ReferredPracticeService referredPracticeService;

    @GetMapping("/addPractice")
    public String addPractice(Model model){
        model.addAttribute("addPractice", new ReferredPractice());
        return "addPractice";
    }

    @PostMapping("/addPractice")
    public String submitReferral (@ModelAttribute ReferredPractice referredPractice){
        if (referredPracticeService.processNewPractice(referredPractice)){
            return "result";
        }
        else {
            return "failed";
        }
    }
}
