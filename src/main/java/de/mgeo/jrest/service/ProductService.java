package de.mgeo.jrest.service;

import de.mgeo.jrest.model.Product;
import de.mgeo.jrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    //Getters
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public Product getByNname(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> getByProject(String name) {
        return productRepo.findByProject(name);
    }


    //Creates
    public Product create(String name, String project, String repo) {
        return productRepo.save(new Product(name, project, repo));
    }

    //Update
    public Product update(String name, String project, String repo) {
        Product p = productRepo.findByName(name);
        p.setName(name);
        p.setProject(project);
        p.setRepo(repo);
        return productRepo.save(p);
    }

    //Deletes
    public void deleteAll() {
        productRepo.deleteAll();
    }

    public void deleteByName(String name) {
        Product p = productRepo.findByName(name);
        productRepo.deleteById(p.getId());
    }
}
