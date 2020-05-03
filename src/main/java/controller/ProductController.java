package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import entity.Product;
import service.ProductService;

import java.util.List;

@RestController
@RequestMapping (path ="/")
public class ProductController {
@Autowired
    private ProductService productService;
    //Get product by name
    @RequestMapping(path = "product/search",method = RequestMethod.GET)
    public List<Product> getProductByName(@RequestParam(required = false) String s){
        return productService.findProduct(s);
    }
    //get Product by id
    @RequestMapping(path = "product",method = RequestMethod.GET)
    public Product getProduct(@RequestParam int id){
        return productService.getProduct(id);
    }
    //add new product
    @RequestMapping(path = "product",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    //update exist students
    @RequestMapping(path = "product",method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @RequestMapping(path = "product/{id}",method = RequestMethod.DELETE)
    public int deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
