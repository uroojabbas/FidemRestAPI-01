package com.vroom.dataservice.services;

import com.vroom.dataservice.com.vroom.dataservice.repository.*;
import com.vroom.dbmodel.orm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ClientTypeRepository clientTypeRepository;

    @Autowired
    InstituteTypeRepository instituteTypeRepository;

    @Autowired
    UserRepository userRepository;

    public Client getClient(int id){
        logger.debug("getClient : [" + id + "]");
        return clientRepository.findById(id);

    }

    public List<Client> getClient(String name){
        logger.debug("getClient : [" + name + "]");
        return clientRepository.findByName(name);
    }

    public List<Client> getAllClients(){
        logger.debug("getAllVendors");
        return clientRepository.findAll();
    }

    public Client save(Client client){
        logger.debug("saveClient : Name[" + client.toString() + "]");

        City city = cityRepository.findBycityname(client.getCityname());
        Region region = regionRepository.findByregionname(client.getRegionname());
        Clienttype clienttype = clientTypeRepository.findByName(client.getClienttypename());
        Institutetype institutetype = instituteTypeRepository.findByName(client.getInstitutetypename());
        Users user = userRepository.findById(client.getUserid());

        client.setIsdeleted(Boolean.FALSE);
        client.setClientstaus(1);
        client.setModifiedtime(new Date());
        client.setCity(city);
        client.setRegion(region);
        client.setClienttype(clienttype);
        client.setInstitutetype(institutetype);

        if(client.getId() == null) {
            client.setUserid(user.getId());
        }else{
            client.setModifiedbyuserid(user.getId());
        }
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
