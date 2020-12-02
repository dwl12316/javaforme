package src.main.com.neusoft.springbootsell.Repository;

import src.main.com.neusoft.springbootsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn (List<Integer> CategoryType);
}
