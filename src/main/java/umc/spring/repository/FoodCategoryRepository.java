package umc.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
