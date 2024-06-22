package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> findAllCartItems();

    void addItemToCart(long productId);

    void increaseAmount(long cartItemId);

    void decreaseAmount(long cartItemId);
}
