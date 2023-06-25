package com.rollingstone.services;


import com.rollingstone.model.Address;
import com.rollingstone.model.Customer;
import com.rollingstone.repository.CustomerAddressRepository;
import com.rollingstone.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerDao;
    @Autowired
    private CustomerAddressRepository addressLineDao;
    public CustomerServiceImpl(CustomerRepository customerDao, CustomerAddressRepository addressLineDao) {
        this.customerDao = customerDao;
        this.addressLineDao = addressLineDao;
    }
    @Override
    public Customer save(Customer customer) {
        logger.info("Received Customer is : " + customer);

        logger.info("Received Address Size is : " + customer.getAddresses().size());
        Customer savedCustomer = customerDao.save(customer);
        for (Address addressLine : savedCustomer.getAddresses()){
            logger.info("LG Address : " + addressLine);
            addressLine.setCustomer(savedCustomer);
            addressLine.setCustomerId(savedCustomer.getCustomerId());
            addressLineDao.save(addressLine);
        }
        return savedCustomer;
    }

    @Override
    public Optional<Customer> get(long id) {
        return Optional.of(customerDao.findByCustomerId(id));
    }

    @Override
    public Page<Customer> getCustomersByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("customerNumber").descending());
        return customerDao.findAll(pageable);
    }

    @Override
    public void update(long id, Customer customer) {

        Address updatedAddress = customer.getAddresses().stream().findFirst().get();
        Customer savedCustomer = customerDao.save(customer);
        for (Address addressLine : savedCustomer.getAddresses()){
            logger.info("LG Address : " + addressLine);
            addressLine.setCustomer(savedCustomer);
            addressLine.setCustomerId(customer.getCustomerId());
            logger.info("LG Address HouseNumber : " + updatedAddress.getHouseNumber());

            addressLine.setHouseNumber(updatedAddress.getHouseNumber());
            logger.info("LG addressLine HouseNumber : " + addressLine.getHouseNumber());
            addressLine.setAddressId(updatedAddress.getAddressId());
            addressLine.setCity(updatedAddress.getCity());
            addressLine.setState(updatedAddress.getState());
            addressLine.setHomePhoneNumber(updatedAddress.getHomePhoneNumber());
            addressLine.setMobilePhoneNumber(updatedAddress.getMobilePhoneNumber());
            addressLine.setStreet(updatedAddress.getStreet());
            addressLine.setZip(updatedAddress.getZip());
            addressLine.setEmailAddress(updatedAddress.getEmailAddress());
            addressLine.setCreatedBy(customer.getCreatedBy());
            addressLine.setCreatedTime(customer.getCreatedTime()== null? LocalDateTime.now() : customer.getCreatedTime());
            addressLine.setUpdatedBy(customer.getUpdatedBy());
            addressLine.setUpdatedTime(customer.getUpdatedTime()== null? LocalDateTime.now() : customer.getUpdatedTime());
            logger.info("LG Address after update: " + addressLine);

            addressLineDao.save(addressLine);
        }
    }

    @Override
    public List<Customer> getAllCustomers(){
        return customerDao.findAll();
    }
    @Override
    public void delete(long id) {
        customerDao.deleteById(id);
    }

}
