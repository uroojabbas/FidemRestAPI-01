package com.vroom.dataservice.services;

import com.vroom.dataservice.com.vroom.dataservice.repository.ClientRepository;
import com.vroom.dbmodel.orm.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    ClientRepository clientRepository;


    public Client getClient(int id){
        logger.debug("getClient : [" + id + "]");
        return clientRepository.findById(id);

    }

    public Client getClient(String name){
        logger.debug("getClient : [" + name + "]");
        return clientRepository.findByName(name);
    }

    public List<Client> getAllClients(){
        logger.debug("getAllVendors");
        return clientRepository.findAll();
    }

    public Client save(Client client){
        logger.debug("saveClient : Name[" + client.toString() + "]");
        // Vendortype vendortype = vendorTypeRepository.findByName(vendor.getType());
        // vendor.setVendortype(vendortype);
        // vendor.setIsdeleted(Boolean.FALSE);
        return clientRepository.save(client);
    }

    public Client delete(@RequestBody int id){
        logger.debug("deleteVendor : Name[" + id + "]");

        Client client = clientRepository.findById(id);

        if(client != null && client.getId() > 0){
            client.setIsdeleted(Boolean.TRUE);
        }

        return clientRepository.save(client);
    }

}
