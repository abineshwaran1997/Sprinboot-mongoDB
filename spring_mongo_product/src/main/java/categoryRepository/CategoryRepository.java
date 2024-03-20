package categoryRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import category.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	
}
