package productService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import product.Product;
import productRepository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	@Autowired
	//public final ProductRepository repository;
	public ProductRepository repository;
	
	public Product saveProduct(Product product) {
	 return this.repository.save(product);
	
		
	}
//	
//	public Optional<Product> findById(String id) {
//		return repository.findById(id);
//		
//	}
	
	public Product findById(String id) {
		return repository.findById(id).orElse(null);
		
	}
	
	
	public List<Product> findAllProduct(){
		return repository.findAll();
	}
	
	public void deleteProduct(String id) {
		repository.deleteById(id);
	}
	
//	public void deleteAllProduct(String id) {
//		repository.deleteAll();
//	}
}
