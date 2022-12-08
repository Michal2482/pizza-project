package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.service.BasicInformationService;
import com.example.pizzaproject.service.DescriptionOnPagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/{prefix}")
public class DescriptionOnPagesController {

    private final DescriptionOnPagesService descriptionOnPagesService;

    public DescriptionOnPagesController(DescriptionOnPagesService descriptionOnPagesService) {
        this.descriptionOnPagesService = descriptionOnPagesService;
    }

    @GetMapping("/admin/descriptionOnPages")
    public String getDescriptionOnPagesForm(Model model, @PathVariable String prefix) {
        DescriptionOnPages descriptionOnPages = descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages", descriptionOnPages);
        return "admin/descriptionOnPages";
    }

    @PostMapping(value="/admin/descriptionOnPages", params="submitAndGoAdminPage")
    public RedirectView postEditDescriptionOnPages(@PathVariable String prefix, DescriptionOnPages descriptionOnPages) {
        descriptionOnPagesService.addDescriptionOnPages(descriptionOnPages, prefix);
        return new RedirectView("");
    }

    @PostMapping(value = "/admin/descriptionOnPages", params="submitAndGoHomePage")
    public RedirectView postEditDescriptionOnPagesAndGoHomePage(DescriptionOnPages descriptionOnPages, @PathVariable String prefix) {
        descriptionOnPagesService.addDescriptionOnPages(descriptionOnPages, prefix);
        return new RedirectView("/{prefix}");
    }

    @PostMapping(value = "/admin/descriptionOnPages", params="delete")
    public RedirectView deleteDescriptionOnPages(@PathVariable String prefix) {
        descriptionOnPagesService.deleteDescriptionOnPages(prefix);
        return new RedirectView("");
    }

    @ModelAttribute
    public void setPrefix(@PathVariable String prefix, Model model){
        model.addAttribute("prefix",prefix);
    }

}
