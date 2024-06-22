package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Category;
import kz.runtime.stat_service.spring63catalog.model.Option;

import java.util.List;

public interface OptionService extends AbstractService<Option> {
    void create(String optionNames, Category category);

    List<Option> findAllByCategoryId(long categoryId);
}



// Создайте табличку для корзины
// - в таблице должна быть несколько товаров и один пользователь