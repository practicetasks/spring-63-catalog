package kz.runtime.stat_service.spring63catalog.repository;

import kz.runtime.stat_service.spring63catalog.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ValueRepository extends JpaRepository<Value, Long> {
    @Transactional
    void deleteAllByProductId(long productId);

    List<Value> findAllByProductId(long productId);

    Optional<Value> findByProductIdAndOptionId(long productId, long optionId);
}
