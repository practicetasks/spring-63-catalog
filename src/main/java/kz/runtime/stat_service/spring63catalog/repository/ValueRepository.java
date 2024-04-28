package kz.runtime.stat_service.spring63catalog.repository;

import kz.runtime.stat_service.spring63catalog.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Long> {
}
