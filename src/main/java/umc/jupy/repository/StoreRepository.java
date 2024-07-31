package umc.jupy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.jupy.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
