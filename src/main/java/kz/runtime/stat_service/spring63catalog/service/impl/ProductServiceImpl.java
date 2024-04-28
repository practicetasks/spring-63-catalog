package kz.runtime.stat_service.spring63catalog.service.impl;

import kz.runtime.stat_service.spring63catalog.model.Category;
import kz.runtime.stat_service.spring63catalog.model.Option;
import kz.runtime.stat_service.spring63catalog.model.Product;
import kz.runtime.stat_service.spring63catalog.model.Value;
import kz.runtime.stat_service.spring63catalog.repository.CategoryRepository;
import kz.runtime.stat_service.spring63catalog.repository.OptionRepository;
import kz.runtime.stat_service.spring63catalog.repository.ProductRepository;
import kz.runtime.stat_service.spring63catalog.repository.ValueRepository;
import kz.runtime.stat_service.spring63catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OptionRepository optionRepository;
    private final ValueRepository valueRepository;

    @Override
    public void create(Product product, long categoryId, List<Long> optionIds, List<String> values) {
        // Находим категорию по id
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        // Устанавливаем категорию для товара
        product.setCategory(category);

        // Сохраняем товар в БД
        productRepository.save(product);

        // Выгружаем все Option объекты разом
        List<Option> options = optionRepository.findAllById(optionIds);

        for (int i = 0; i < optionIds.size(); i++) {
            // Достаем Option из списка
            Option option = options.get(i);

            // Достаем значение характеристики
            String valueName = values.get(i);

            // Создание объекта Value (значение характеристики)
            Value value = new Value();
            value.setName(valueName);
            value.setProduct(product);
            value.setOption(option);
            valueRepository.save(value);
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
