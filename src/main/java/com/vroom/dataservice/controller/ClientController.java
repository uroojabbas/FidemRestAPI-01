package com.vroom.dataservice.controller;

import com.vroom.dataservice.com.vroom.dataservice.repository.ClientRepository;
import com.vroom.dataservice.services.ClientService;
import com.vroom.dbmodel.orm.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @GetMapping("/client/{id}")
    @ResponseBody
    public Client getClient(@PathVariable int id){
        logger.debug("getClient : [" + id + "]");
        return clientService.getClient(id);

    }

    @GetMapping("/client/{name}")
    public Client getClient(@PathVariable String name){
        logger.debug("getClient : [" + name + "]");
        return clientService.getClient(name);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        logger.debug("getAllClients");
        return clientService.getAllClients();
    }

    @PostMapping(value = "/client/save",consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Client saveClient(@RequestBody Client client){
        logger.debug("save Client : Name[" + client.toString() + "]");
        return clientService.save(client);
    }

    @PostMapping(value = "/client/delete",consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Client deleteClient(@RequestBody int id){
        logger.debug("delete Client : Name[" + id + "]");
        return clientService.delete(id);
    }

}
