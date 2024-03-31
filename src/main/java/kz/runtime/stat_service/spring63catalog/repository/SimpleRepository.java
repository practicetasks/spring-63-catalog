package kz.runtime.stat_service.spring63catalog.repository;

import java.util.List;

public interface SimpleRepository<T> {
    T findById(long id);

    List<T> findAll();

    void create(T t);
}
