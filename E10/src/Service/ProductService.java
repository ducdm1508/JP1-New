package Service;

import Entity.Product;
import Global.ProductValidation;
import Exception.InvalidProducIdException;
import Exception.InvalidProductNameException;
import Exception.InvalidQuantityException;
import Exception.NotFoundProductIdException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> createProduct(Product product) throws InvalidProducIdException, InvalidProductNameException, InvalidQuantityException {
        if (!ProductValidation.validateProId(product.getId())) {
            throw new InvalidProducIdException("Invalid product ID format: " + product.getId());
        }
        if (!ProductValidation.validateProName(product.getName())) {
            throw new InvalidProductNameException("Invalid product name format: " + product.getName());
        }
        if (product.getQuantity() <= 0) {
            throw new InvalidQuantityException("Invalid quantity: " + product.getQuantity());
        }
        products.add(product);
        return products;
    }

    public Product getProductById(String id) throws NotFoundProductIdException {
        try {
            Optional<Product> getProId = products.stream()
                    .filter(p -> p.getId().equalsIgnoreCase(id))
                    .findFirst();
            return getProId.get();
        } catch (NoSuchElementException e) {
            throw new NotFoundProductIdException("Not found: " + id);
        }
    }
}