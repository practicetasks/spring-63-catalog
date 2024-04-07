package kz.runtime.stat_service.spring63catalog.repository;

import kz.runtime.stat_service.spring63catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
