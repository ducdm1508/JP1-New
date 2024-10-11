package Controller;

import Entity.Product;
import Service.ProductService;
import Exception.InvalidProducIdException;
import Exception.InvalidProductNameException;
import Exception.InvalidQuantityException;
import Exception.NotFoundProductIdException;

import java.util.List;

public class ProductController {
    private ProductService ps;

    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    public List<Product> createProduct(Product product) {
        try {
            List<Product> products = ps.createProduct(product);
            System.out.println("Product created successfully!");
            return products;
        } catch (InvalidProducIdException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (InvalidProductNameException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public Product getProductById(String id) throws NotFoundProductIdException{
        try {
            return ps.getProductById(id);
        }catch (NotFoundProductIdException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}