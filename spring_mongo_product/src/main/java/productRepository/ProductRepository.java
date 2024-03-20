package productRepository;

//import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	//Product saveAll(Product product);
	
	List<Product> findAllByNameIgnoreCase(String name);
		
	List<Product> findAllByStartingWith(String name);
	
	List<Product> findAllByEndsWith(String name);
	
	List<Product> findAllByContiningIgnoreCase(String name);
	
	List<Product> findAllByPriceLessThen(BigDecimal price);
	
	List<Product> findAllByPriceGreaterThen(BigDecimal price);
	
	List<Product> findAllByPriceBetween(BigDecimal price1,BigDecimal price2);

	List<Product> findAllByContiningIgnoreCaseOrderByPrice(String name);
	
	List<Product> findAllByContiningIgnoreCaseOrderByPrice(String name,PageRequest page);
	
}
