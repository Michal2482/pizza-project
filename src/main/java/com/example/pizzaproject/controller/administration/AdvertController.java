package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.service.AdvertService;
import com.example.pizzaproject.validation.FileValidator;

import com.example.pizzaproject.validation.ValidImage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/{prefix}")
@Validated
public class AdvertController {

    private final AdvertService advertService;


    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/admin/addAdvert")
    public String getAdvertForm(@PathVariable String prefix, final ModelMap modelMap) {
        modelMap.addAttribute("form",new Advert());
        return "advert/addAdvert";
    }

    @PostMapping(value="/admin/addAdvert",  params="submitAndGoAdminPage")
    public String postAddAdvert(@PathVariable String prefix, @ValidImage @RequestParam(value = "file")  MultipartFile file,
                                      @ModelAttribute("form") @Valid Advert advert, BindingResult result,Model model) {
        if (result.hasErrors()){
            model.addAttribute("errorMessage","You must send photo with sufix .jpg or .png");
            return "advert/addAdvert";
        } else {
            advertService.store(file);
            advertService.addAdvert(advert, prefix, file.getOriginalFilename());
            return "redirect:/{prefix}/admin";
        }
    }

    @PostMapping(value="/admin/addAdvert",  params="submitAndGoHomePage")
    public RedirectView postAddAdvertAndGoHomePage(@PathVariable String prefix, Advert advert, @RequestParam("file") MultipartFile file) {
        advertService.store(file);
        advertService.addAdvert(advert, prefix, file.getOriginalFilename());
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
    @PostMapping(value="/admin/editAdvert/{id}",  params="submitAndGoAdverts")
    public RedirectView postEditAdvert(@PathVariable("prefix") String prefix, @PathVariable("id") Long id,
                                       Advert advert, @RequestParam(name = "file", required = false) MultipartFile file) {
        advertService.editAdvert(advert, prefix, file);
        return new RedirectView("/{prefix}/admin/adverts");
    }

    @PostMapping(value="/admin/editAdvert/{id}",  params="submitAndGoHomePage")
    public RedirectView postEditAdvertAndGoHomePage(@PathVariable("prefix") String prefix, @PathVariable("id") Long id,
                                                    Advert advert, @RequestParam(name = "file", required = false) MultipartFile file) {
        advertService.editAdvert(advert, prefix, file);
        return new RedirectView("/{prefix}");
    }

    @PostMapping(value="/admin/deleteAdvert/{id}",  params="delete")
    public RedirectView deleteAdvert(@PathVariable("prefix") String prefix, @PathVariable("id") Long id) {
        advertService.deleteAdvert(id);
        return new RedirectView("/{prefix}/admin/adverts");
    }

    @GetMapping(value = "/advert/{id}/image")
    @ResponseBody
    public Resource getImageForAdvert(@PathVariable Long id){
        return advertService.loadAsResourceByAdvertId(id);
    }

}
