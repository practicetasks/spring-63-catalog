package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Product;
import kz.runtime.stat_service.spring63catalog.model.Value;

import java.util.List;

public interface ProductService {
    void create(Product product, long categoryId, List<Long> optionIds, List<String> values);

    void update(long productId, String updatedName, double updatedPrice, List<Long> optionIds, List<String> values);

    List<Product> findAll();

    Product findById(long id);

    void deleteById(long id);

    List<Value> findValuesByProductId(long id);
}
