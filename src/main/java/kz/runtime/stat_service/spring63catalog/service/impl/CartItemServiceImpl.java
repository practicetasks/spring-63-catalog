package kz.runtime.stat_service.spring63catalog.service.impl;

import kz.runtime.stat_service.spring63catalog.exception.EntityNotFoundException;
import kz.runtime.stat_service.spring63catalog.model.CartItem;
import kz.runtime.stat_service.spring63catalog.model.Product;
import kz.runtime.stat_service.spring63catalog.model.User;
import kz.runtime.stat_service.spring63catalog.repository.CartItemRepository;
import kz.runtime.stat_service.spring63catalog.repository.ProductRepository;
import kz.runtime.stat_service.spring63catalog.service.CartItemService;
import kz.runtime.stat_service.spring63catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserService userService;

    @Override
    public void addItemToCart(long productId) {
        CartItem cartItem = new CartItem();
        cartItem.setUser(userService.getUser().orElseThrow());

        Product product = productRepository.findById(productId).orElseThrow();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);

        cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findAllCartItems() {
        User user = userService.getUser().orElseThrow();
        return cartItemRepository.findAllByUserOrderById(user);
    }

    @Override
    public void increaseAmount(long cartItemId) {
        CartItem cartItem = getById(cartItemId);
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void decreaseAmount(long cartItemId) {
        CartItem cartItem = getById(cartItemId);
        cartItem.setQuantity(cartItem.getQuantity() - 1);
        cartItemRepository.save(cartItem);
    }

    private CartItem getById(long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Сущность не найден"));
    }
}