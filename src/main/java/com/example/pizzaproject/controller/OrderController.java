package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.MealService;
import com.example.pizzaproject.service.OrderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/{prefix}")
public class OrderController {

    private final OrderService orderService;
    private final MealService mealService;

    public OrderController(OrderService orderService, MealService mealService) {
        this.orderService = orderService;
        this.mealService = mealService;
    }


    @GetMapping("/order")
    public String getOrder(@PathVariable String prefix, Model model) {
        model.addAttribute("order", orderService.getOrder());
        model.addAttribute("sum", orderService.totalPrice());
        return "pizzaPage/order";
    }

    @GetMapping("/order/add")
    public RedirectView addMealToOrder(@PathVariable String prefix, @RequestParam Long mealId, Model model) {
        Meal mealToAdded = mealService.getMeal(mealId);
        orderService.add(mealToAdded);
        return new RedirectView("/{prefix}/menu");
    }
}
