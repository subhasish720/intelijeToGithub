package com.example.client.service;

import com.example.client.jpa.CustomerDao;
import com.example.client.model.dto.CustomerDto;
import com.example.client.model.entity.CustomerEntity;
import com.example.client.thirdparty.AdharDto;
import org.slf4j.Logger;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    public CustomerEntity addCustomerDetails(CustomerDto customerDto) {
        Optional<CustomerEntity> customerEntity = customerDao.findById(customerDto.getId());
        CustomerEntity customerEntity1;
        CustomerEntity customerEntity2;
        if(customerEntity.isEmpty()){
                if(customerDto != null && getAdharDetails(customerDto.getAdharcard_number()) != null && customerDto.getName() != null && getAdharDetails(customerDto.getAdharcard_number()).getName() != null && customerDto.getAdharcard_number() != null && getAdharDetails(customerDto.getAdharcard_number()).getAdharcard_number() != null) {
                    if (customerDto.getName().equals(getAdharDetails(customerDto.getAdharcard_number()).getName()) && customerDto.getAdharcard_number().equals(getAdharDetails(customerDto.getAdharcard_number()).getAdharcard_number())) {
                        customerEntity1 = modelMapper.map(customerDto, CustomerEntity.class);
                        if(customerDto.getLoan_amount() < 300000){
                            customerEntity1.setFlag(true);
                            customerEntity2 = customerDao.save(customerEntity1);
                            return customerEntity2;
                        } else {
                            customerEntity1.setFlag(false);
                            customerEntity2 = customerDao.save(customerEntity1);
                            return customerEntity2;
                        }
                    }
                }
        }
        return null;
    }
    public CustomerDto getCustomerDetails(int id){
        Optional<CustomerEntity> customerEntity = customerDao.findById(id);
        CustomerDto customerDto;
        if(customerEntity.isPresent()){
            customerDto = modelMapper.map(customerEntity.get(), CustomerDto.class);
            return customerDto;
        }
        logger.info("There is no data present with the given id");
        return null;
    }
    public CustomerEntity updateCustomerDetails(CustomerDto customerDto){
        Optional<CustomerEntity> customerEntity = customerDao.findById(customerDto.getId());
        CustomerEntity customerEntity1;
        if(customerEntity.isPresent()){
            customerEntity1 = modelMapper.map(customerDto, CustomerEntity.class);
            return customerDao.save(customerEntity1);
        }
        logger.warn("There is no data to update with the given id");
        return null;
    }
    public void deleteCustomerDetails(int id){
        Optional<CustomerEntity> customerEntity = customerDao.findById(id);
        if(customerEntity.isPresent()){
            customerDao.delete(customerEntity.get());
            logger.info("The data with the given id has been deleted");
        }
    }
    public List<CustomerDto> getAllCustomerDetails(){
        List<CustomerEntity> listOfClient = customerDao.findAll();
        List<CustomerDto> list1 = new LinkedList<>();
        if(listOfClient.size() > 0) {
            logger.info("The data is present");
            for (CustomerEntity list2 : listOfClient) {
                CustomerDto customerDto = modelMapper.map(list2, CustomerDto.class);
                list1.add(customerDto);
            }
            return list1;
        }
        logger.info("There is no data the database");
        return list1;
    }

    public AdharDto getAdharDetails(String adharcard_number){
        try {
            AdharDto adharDto = webClient.get()
                    .uri("/adharcard/api/get/{adharcard_number}", adharcard_number)
                    .retrieve()
                    .bodyToMono(AdharDto.class)
                    .block();
            return adharDto;
        }catch(Exception e){
            return null;
        }
    }

}
