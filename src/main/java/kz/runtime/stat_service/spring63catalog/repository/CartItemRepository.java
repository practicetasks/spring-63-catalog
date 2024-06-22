package kz.runtime.stat_service.spring63catalog.repository;

import kz.runtime.stat_service.spring63catalog.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
