package com.vroom.dataservice.services;

import com.vroom.dataservice.com.vroom.dataservice.repository.LanguageRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.ProductRepository;
import com.vroom.dataservice.com.vroom.dataservice.repository.UserRepository;
import com.vroom.dbmodel.orm.Language;
import com.vroom.dbmodel.orm.Product;
import com.vroom.dbmodel.orm.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

   
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ProductRepository productRepository;

    @Autowired
    LanguageRepository languageRepository;

    public Product getProduct(int id){
        logger.debug("getProduct : [" + id + "]");
        return productRepository.findById(id);

    }

    public List<Product> getProduct(String name){
        logger.debug("getProduct : [" + name + "]");
        return productRepository.findByName(name);
    }

    public List<Product> getAllProducts(){
        logger.debug("getAllVendors");
        return productRepository.findAll();
    }

    public Product save(Product product){
        logger.debug("saveProduct : Name[" + product.toString() + "]");

        Users user = userRepository.findById(product.getUserid());
        Language language = languageRepository.findByLanguage(product.getLanguagename());
        product.setIsdeleted(Boolean.FALSE);
        if((product.getLanguage() != null) && !(product.getLanguage().getLanguage().equalsIgnoreCase(product.getLanguagename()))) {
            product.setLanguage(language);
        }

        if(product.getId() == null) {
            product.setUserid(user.getId());
            product.setInsertedtime(new Date());
        }else{
            product.setModifiedtime(new Date());
            product.setModifiedbyuserid(user.getId());
        }
        return productRepository.save(product);
    }

    public Product delete(@RequestBody int id){
        logger.debug("deleteVendor : Name[" + id + "]");

        Product product = productRepository.findById(id);

        if(product != null && product.getId() > 0){
            product.setIsdeleted(Boolean.TRUE);
        }

        return productRepository.save(product);
    }

}
