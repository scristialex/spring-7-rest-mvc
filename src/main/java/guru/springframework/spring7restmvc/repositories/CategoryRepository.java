package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
