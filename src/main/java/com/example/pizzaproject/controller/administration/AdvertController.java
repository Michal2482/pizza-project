package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.service.AdvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/{prefix}")
public class AdvertController {

    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/admin/addAdvert")
    public String getAdvertForm(@PathVariable String prefix) {
        return "advert/addAdvert";
    }

    @PostMapping(value="/admin/addAdvert",  params="submitAndGoAdminPage")
    public RedirectView postAddAdvert(@PathVariable String prefix, Advert advert) {
        advertService.addAdvert(advert, prefix);
        return new RedirectView("");
    }

    @PostMapping(value="/admin/addAdvert",  params="submitAndGoHomePage")
    public RedirectView postAddAdvertAndGoHomePage(@PathVariable String prefix, Advert advert) {
        advertService.addAdvert(advert, prefix);
        return new RedirectView("/{prefix}");
    }

    @GetMapping("/admin/adverts")
    public String getListAdverts(Model model, @PathVariable String prefix) {
        List<Advert> advertList = advertService.getAdverts(prefix);
        model.addAttribute("adverts", advertList);
        return "advert/adverts";
    }

    @GetMapping("/admin/editAdvert/{id}")
    public String getEditAdvert(@PathVariable("prefix") String prefix, @PathVariable("id") Long id, Model model) {
        Advert advert = advertService.getAdvert(id);
        model.addAttribute("advert",advert);
        return "advert/editAdvert";
    }
    @PostMapping(value="/admin/editAdvert/{id}",  params="submitAndGoAdminPage")
    public RedirectView postEditAdvert(@PathVariable("prefix") String prefix, @PathVariable("id") Long id, Advert advert) {
        advertService.addAdvert(advert, prefix);
        return new RedirectView("/{prefix}/admin");
    }

    @PostMapping(value="/admin/editAdvert/{id}",  params="submitAndGoHomePage")
    public RedirectView postEditAdvertAndGoHomePage(@PathVariable("prefix") String prefix, @PathVariable("id") Long id, Advert advert) {
        advertService.addAdvert(advert, prefix);
        return new RedirectView("/{prefix}");
    }

    @PostMapping(value="/admin/editAdvert/{id}",  params="delete")
    public RedirectView deleteAdvert(@PathVariable("prefix") String prefix, @PathVariable("id") Long id) {
        advertService.deleteAdvert(id, prefix);
        return new RedirectView("/{prefix}/admin");
    }

}
