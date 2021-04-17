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

    @GetMapping("/{id}")
    public Product getOne(@PathVariable int id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product create(@RequestBody Product customer) {
        Product record = productRepository.save(customer);
        productRepository.flush();
        return record;
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        Product record = productRepository.findById(id).get();
        record.setProductPrice(product.getProductPrice());
        productRepository.save(record);
        return record;
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable int id) {
        Product record = productRepository.findById(id).get();
        productRepository.deleteById(id);
        return record;
    }

}
