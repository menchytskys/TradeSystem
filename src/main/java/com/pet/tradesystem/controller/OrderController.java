package com.pet.tradesystem.controller;

import com.pet.tradesystem.domain.Product;
import com.pet.tradesystem.domain.Order;
import com.pet.tradesystem.domain.Purchase;
import com.pet.tradesystem.domain.User;
import com.pet.tradesystem.service.impl.OrderServiceImpl;
import com.pet.tradesystem.service.impl.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.pet.tradesystem.controller.LoginCheckUtil.isUserLoggedIn;
import static com.pet.tradesystem.util.ProductUtils.getProducts;

@Controller
@RequestMapping("/")
public class OrderController {

    private final OrderServiceImpl orderService;
    private final PurchaseServiceImpl purchaseService;

    @Autowired
    public OrderController(OrderServiceImpl orderService, PurchaseServiceImpl purchaseService) {
        this.orderService = orderService;
        this.purchaseService = purchaseService;
    }

    @GetMapping(value = "/order")
    public String getListOfGoods(HttpServletResponse response, HttpServletRequest request, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (isUserLoggedIn(response, request, session)) {
            return null;
        }
        List<Purchase> userPurchases = purchaseService.findPurchasesByUserId(user.getId());
        List<Product> products = getProducts(userPurchases);
        model.addAttribute("products", products);

        return "/order";
    }

    @PostMapping(value = "/addOrder")
    public String saveOrder(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (isUserLoggedIn(response, request, session)) {
            return null;
        }
        Order order = new Order();
        order.setUserId(user.getId());
        orderService.add(order);

        return "redirect:/order";
    }
}
