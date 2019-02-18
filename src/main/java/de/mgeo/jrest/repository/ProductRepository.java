package de.mgeo.jrest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import de.mgeo.jrest.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository <Product,String> {
    public Product findByName(String name);
    public List<Product> findByProject(String project);
}
