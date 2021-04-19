package th.ac.ku.product.controller;

import th.ac.ku.product.data.ProductRepository;
import th.ac.ku.product.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Product getOne(@PathVariable int productId){
        return productRepository.findById(productId).get();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        Product record = productRepository.save(product);
        productRepository.flush();
        return record;
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        Product record = productRepository.findById(id).get();
        record.setProductPrice(product.getProductPrice());
        productRepository.save(record);
        return record;
    }

    @DeleteMapping("/{productId}")
    public Product delete(@PathVariable int productId) {
        Product record = productRepository.findById(productId).get();
        productRepository.deleteById(productId);
        return record;
    }

}
