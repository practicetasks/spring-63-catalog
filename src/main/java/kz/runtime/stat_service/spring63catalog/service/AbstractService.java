package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.Category;

import java.util.List;

public interface AbstractService<T> {
    List<T> findAll();

    T findById(long id);

    void create(T entity);

    void update(long id, T updatedEntity);

    void deleteById(long id);
}
