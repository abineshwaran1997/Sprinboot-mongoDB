package productCotroller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import product.Product;
import productService.QueryMethodService;

@RestController
public class QueryMethodController {
	
	private QueryMethodService service;
	
	@GetMapping("/search/is")
	public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchByName(name));
	}
	
	@GetMapping("/search/startswith")
	public ResponseEntity<List<Product>> searchByNameStartingWith(@RequestParam("name") String name){
		return ResponseEntity.ok(service.searchByNameStartingWith(name));
	}
	
	@GetMapping("/search/endswith")
	public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name ){
		return ResponseEntity.ok(service.searchByNameStartingWith(name));
	}
	
	@GetMapping("/search/lt")
	public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price ){
		return ResponseEntity.ok(service.searchByPriceLt(price));
	}
	
	@GetMapping("/search/gt")
	public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price ){
		return ResponseEntity.ok(service.searchByPriceLt(price));
	}
	
	@GetMapping("/sort/asc")
	public ResponseEntity<List<Product>> sortAscByField(@RequestParam("field") String field ){
		return ResponseEntity.ok(service.SearchSortAsc(field));
	}
	
	@GetMapping("/sortpage")
	public ResponseEntity<List<Product>> sortAndPageByField(@RequestParam("field") String field,
			@RequestParam(value="pageNumber",required=false,defaultValue="0") int pageNumber,
			@RequestParam(value="size",required=false,defaultValue="2") int size
			){
		return ResponseEntity.ok(service.sortAndPageByField(field,pageNumber,size));
	}
	
	@GetMapping("/search/between")
	public ResponseEntity<List<Product>> searchByPriceBetween(
			@RequestParam("price1") BigDecimal price1,
			@RequestParam("price2") BigDecimal price2){
		return ResponseEntity.ok(service.searchByPriceBetween(price1, price2));
	}
	
}
