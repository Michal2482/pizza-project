package com.example.pizzaproject.controller.administration;


import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.service.BasicInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BasicInformationController {

    private final BasicInformationService basicInformationService;

    public BasicInformationController(BasicInformationService basicInformationService) {
        this.basicInformationService = basicInformationService;
    }

    @GetMapping("/admin/basicInformation")
    public String getBasicInformationForm(Model model) {
        BasicInformation basicInformation = basicInformationService.getInformation("pizzeria");
        model.addAttribute("basicInformation", basicInformation);
        return "admin/basicInformation";
    }

    @PostMapping(value="/admin/basicInformation", params="submitAndGoAdminPage")
    public RedirectView postEditBasicInformation(BasicInformation basicInformation) {
        basicInformationService.addBasicInformation(basicInformation, "pizzeria");
        return new RedirectView("");
    }

    @PostMapping(value = "/admin/basicInformation", params="submitAndGoHomePage")
    public RedirectView postEditBasicInformationAndGoHomePage(BasicInformation basicInformation) {
        basicInformationService.addBasicInformation(basicInformation, "pizzeria");
        return new RedirectView("/");
    }

    @PostMapping(value = "/admin/basicInformation", params="delete")
    public RedirectView deleteBasicInformation() {
        basicInformationService.deleteBasicInformation("pizzeria");
        return new RedirectView("");
    }

//    @PostMapping("/")
//    public RedirectView postEditBasicInformationAndRedirectHome(BasicInformation basicInformation) {
//        basicInformationService.addBasicInformation(basicInformation, "pizzeria");
//        return new RedirectView("/");
//    }

}
