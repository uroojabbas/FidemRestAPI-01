package com.vroom.dataservice.Product;

import com.vroom.dataservice.common.Region;
import com.vroom.dbmodel.orm.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable int id){
        logger.debug("getProductById : [" + id + "]");
        return productService.getProduct(id);

    }

    @GetMapping("/product/vendor/{vendorId}")
    @ResponseBody
    public List<Product> getProductByVendorId(@PathVariable int vendorId){
        logger.debug("getProductById : [" + vendorId + "]");
        return productService.getProductByVendorId(vendorId);

    }

    @GetMapping("/productbyname/{name}")
    public List<Product> getProductByName(@PathVariable String name){
        logger.debug("getProductByName : [" + name + "]");
        return productService.getProduct(name);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        logger.debug("getAllProducts");
        return productService.getAllProducts();
    }

    @GetMapping("/products/region/{regionName}")
    public Collection<Product> getProductsByRegion(@PathVariable Region regionName){
        logger.debug("getProductsByRegion");
        return productService.getProductsByRegion(regionName);
    }

    @PostMapping(value = "/product/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Product saveProduct(@RequestBody Product product){
        logger.debug("save Product : Name[" + product.toString() + "]");
        return productService.save(product);
    }

    @PostMapping(value = "/product/delete",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Product deleteProduct(@RequestBody int id){
        logger.debug("delete Product : Name[" + id + "]");
        return productService.delete(id);
    }

}
