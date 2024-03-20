package productCotroller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import categoryService.CategoryService;
//import lombok.RequiredArgsConstructor;
import product.Product;
import productService.ProductService;

@RestController
// @RequestMapping("/api/product")
//@RequiredArgsConstructor

public class ProductController {
	@Autowired
	public ProductService service;
	public CategoryService searchservice;

//	@PostMapping("/product")
//	public ResponseEntity<Product> save(@RequestBody Product product) {
//		return ResponseEntity.ok(service.saveProduct(product));
//	}
	@PostMapping("/product")
	public String addvalues(@RequestBody Product product ) {
	 this.service.saveProduct(product);
	 return "saved id"+product.getId();
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(service.findAllProduct());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findById(id));
	}

	public ResponseEntity<Product> delete(@PathVariable String id) {
		service.deleteProduct(id);
		// return ResponseEntity.ok(service.deleteProduct(id));
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/search/is")
	public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name){
		return ResponseEntity.ok(searchservice.searchByName(name));
	}
	
	@GetMapping("/search/startswith")
	public ResponseEntity<List<Product>> searchByNameStartingWith(@RequestParam("name") String name){
		return ResponseEntity.ok(searchservice.searchByNameStartingWith(name));
	}
	
	@GetMapping("/search/endswith")
	public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name ){
		return ResponseEntity.ok(searchservice.searchByNameStartingWith(name));
	}
	
	@GetMapping("/search/lt")
	public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price ){
		return ResponseEntity.ok(searchservice.searchByPriceLt(price));
	}
	
	@GetMapping("/search/gt")
	public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price ){
		return ResponseEntity.ok(searchservice.searchByPriceLt(price));
	}
	
	@GetMapping("/sort/asc")
	public ResponseEntity<List<Product>> sortAscByField(@RequestParam("field") String field ){
		return ResponseEntity.ok(searchservice.sortAscByField(field));
	}
	
	@GetMapping("/sortpage")
	public ResponseEntity<List<Product>> sortAndPageByField(@RequestParam("field") String field ){
		return ResponseEntity.ok(searchservice.sortAndPageByField(field));
	}
	
	

}
