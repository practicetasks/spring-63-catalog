package kz.runtime.stat_service.spring63catalog.controller;

import kz.runtime.stat_service.spring63catalog.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartItemService cartItemService;

    @GetMapping
    public String getCartPage(Model model) {
        model.addAttribute("cartItems", cartItemService.findAllCartItems());
        return "cart";
    }

    @PostMapping("/{productId}")
    public String addItemToCart(@PathVariable long productId) {
        cartItemService.addItemToCart(productId);
        return "redirect:/cart";
    }

    @GetMapping("/{id}/increase")
    public String increaseAmount(@PathVariable long id) {
        cartItemService.increaseAmount(id);
        return "redirect:/cart";
    }

    @GetMapping("/{id}/decrease")
    public String decreaseAmount(@PathVariable long id) {
        cartItemService.decreaseAmount(id);
        return "redirect:/cart";
    }
}
