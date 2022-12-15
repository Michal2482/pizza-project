package com.example.pizzaproject.controller;

import com.example.pizzaproject.common.Message;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.model.Order;
import com.example.pizzaproject.service.MealService;
import com.example.pizzaproject.service.OrderService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;

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
        Order order = orderService.getOrder();
        model.addAttribute("order", order);
        BigDecimal totalPrice = orderService.totalPrice();
        model.addAttribute("sum", totalPrice);
        return "pizzaPage/order";
    }

    @GetMapping("/order/add")
    public RedirectView addMealToOrder(@PathVariable String prefix, @RequestParam Long mealId) {
        Meal mealToAdded = mealService.getMeal(mealId);
        orderService.add(mealToAdded);
        return new RedirectView("/{prefix}/menu");
    }

    @PostMapping("/order/pay")
    public String postPayOrderAndRealize(@RequestParam String address, @RequestParam String telephone, Model model) {
        Order order = orderService.postOrderToRealize(address, telephone);
        model.addAttribute("message", new Message("Dziękujemy", "Zamówienie przekazane do realizacji"));
        return "message";
    }


}
