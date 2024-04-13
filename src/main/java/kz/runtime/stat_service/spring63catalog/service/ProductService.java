package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Product;

import java.util.List;

public interface ProductService {
    void create(Product product, long categoryId, List<Long> optionIds, List<String> values);

    List<Product> findAll();
}
