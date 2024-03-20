package productService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import product.Product;
import productRepository.ProductRepository;

@Service
@RequiredArgsConstructor
public class QueryMethodService {
	
	private ProductRepository repository;

	public List<Product> searchByName(String name) {
		// TODO Auto-generated method stub
		return repository.findAllByNameIgnoreCase(name);
	}
	
	public List<Product> searchByNameStartingWith(String name) {
		// TODO Auto-generated method stub
		return repository.findAllByStartingWith(name);
	}
	
	public List<Product> searchByNameEndsWith(String name) {
		// TODO Auto-generated method stub
		return repository.findAllByEndsWith(name);
	}
	
	public List<Product> searchByNameContaining(String name) {
		// TODO Auto-generated method stub
		return repository.findAllByContiningIgnoreCase (name);
	}
	
	public List<Product> searchByPriceLt(BigDecimal price) {
		// TODO Auto-generated method stub
		return repository.findAllByPriceLessThen(price);
	}
	
	public List<Product> searchByPriceGt(BigDecimal price) {
		// TODO Auto-generated method stub
		return repository.findAllByPriceGreaterThen(price);
	}
	
	public List<Product> searchByPriceBetween(BigDecimal price1,BigDecimal price2 ){
		return repository.findAllByPriceBetween(price1,price2);
	}
	
	public List<Product> SearchSortAsc(String name){
		return  repository.findAllByContiningIgnoreCaseOrderByPrice(name);
	}
	
	public List<Product> sortAndPageByField(String name,
			int pageNumber,
			int size){
		PageRequest page=PageRequest.of(pageNumber, size);
		return  repository.findAllByContiningIgnoreCaseOrderByPrice(name,page);
	}

}
