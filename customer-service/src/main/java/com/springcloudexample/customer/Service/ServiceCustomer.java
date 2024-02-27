package com.springcloudexample.customer.Service;

import com.springcloudexample.customer.Entity.Customer;
import com.springcloudexample.customer.Entity.Region;
import com.springcloudexample.customer.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCustomer implements IServiceCustomer{
    private ICustomerRepository repository;

    @Override
    public Customer findCustumerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findCustomersByByRegion(Region region) {
        return repository.findCustomerByRegion(region);
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return repository.findCustomerByLastName(name);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDB = repository.findCustumerById(customer.getId());

        if(customerDB != null)
            return customerDB;

        customer.setState("CREATED");
        return repository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDB = repository.findCustumerById(customer.getId());

        if(customerDB == null)
            return null;
        customerDB.setState("DELETED");
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerDB = repository.findCustumerById(id);

        if (customerDB == null)
            return null;

        customer.setId(id);
//        customerDB.setEmail(customer.getEmail());
//        customerDB.setRegion(customer.getRegion());
//        customerDB.setLastName(customer.getLastName());
//        customerDB.setFirstName(customer.getFirstName());
//        customerDB.setNumberId(customer.getNumberId());
//        customerDB.setPhotoUrl(customer.getPhotoUrl());


        return repository.save(customer);
    }


}
