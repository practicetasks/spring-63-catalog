package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Category;
import kz.runtime.stat_service.spring63catalog.model.Option;

import java.util.List;

public interface CategoryService extends AbstractService<Category> {
    List<Option> findOptionsByCategoryId(long categoryId);
}
