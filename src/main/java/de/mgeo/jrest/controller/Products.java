package de.mgeo.jrest.controller;

import de.mgeo.jrest.model.Product;
import de.mgeo.jrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
public class Products {
    private static final Logger logger = LogManager.getLogger(Products.class);

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.POST, value="/api/create/{pproduct}/{pproject}/{prepo}")
    public String create(@PathVariable("pproduct") String product, @PathVariable("pproject") String project, @PathVariable("prepo") String repo) {
        if (productService.getByNname(product) != null) {
            logger.warn("Product "+product+" already exists!");
            return "{\n'status': 400, 'message': 'Product <"+product+"> already exists!'\n}";
        }

        Product p = productService.create(product, project, repo);
        return p.toString();
    }

//    @RequestMapping("/api/getByName")
//    public Product getByName(@RequestParam String name) {
//        return productService.getByNname(name);
//    }

    @RequestMapping(method = RequestMethod.GET, value="/api/product/{pname}")
    public Product getByName(@PathVariable("pname") String name) {
        return productService.getByNname(name);
    }

    @RequestMapping(method = RequestMethod.GET, value="/api/project/{pproject}")
    public List<Product> getByProject(@PathVariable("pproject") String project) {
        //(@RequestParam String project) {
        return productService.getByProject(project);
    }


    @RequestMapping(method = RequestMethod.GET, value="/api/get")
    public List<Product> getAll() {
        return productService.getAll();
    }


    @RequestMapping(method = RequestMethod.POST, value="/api/update/{pproduct}/{pproject}/{prepo}")
    public String update (@PathVariable("pproduct") String product, @PathVariable("pproject") String project, @PathVariable("prepo") String repo) {
        if (productService.getByNname(product) != null) {
            Product p = productService.update(product,project,repo);
            return p.toString();
        }
        else {
            logger.warn("Product "+product+" not found!");
            return "{\n\t'status': 400, \n\t'message': 'Product <" + product + "> not found!'\n}";
        }
    }



    /* FORMULAR - HANLING */
    @RequestMapping(method = RequestMethod.POST, value="/api/form/create")
    public String formCreate(@RequestParam String product, @RequestParam String project, @RequestParam String repo) {
        if (productService.getByNname(product) != null) {
            logger.warn("Product "+product+" already exists!");
            return "{\n'status': 400, 'message': 'Product <"+product+"> already exists!'\n}";
        }

        Product p = productService.create(product, project, repo);
        return p.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value="/api/form/update")
    public String formUpdate (@RequestParam String product, @RequestParam String project, @RequestParam String repo) {
        if (productService.getByNname(product) != null) {
            Product p = productService.update(product,project,repo);
            return p.toString();
        }
        else {
            logger.warn("Product "+product+" not found!");
            return "{\n\t'status': 400, \n\t'message': 'Product <" + product + "> not found!'\n}";
        }
    }



    /* DELETE FUNCTIONS */
    @RequestMapping(method = RequestMethod.POST, value="/api/deleteAll")
    public String deleteAll() {
        productService.deleteAll();
        return "{\n'status': 200, 'message': 'All Products deleted!'\n}";
    }

    @RequestMapping(method = RequestMethod.POST, value="/api/delete/{name}")
    public String delete(@RequestParam String name) {
        productService.deleteByName(name);
        return "{\n\t'status': 200, \n\t'message': 'Product <" + name + "> deleted!'\n}";
        //return "{\n\t'status': 400, \n\t'message': 'Product <" + name + "> not found!'\n}";
    }

}
