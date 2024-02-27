package com.springcloudexample.customer.Service;

import com.springcloudexample.customer.Entity.Customer;
import com.springcloudexample.customer.Entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServiceCustomer {
    Customer findCustumerById(Long id);
    List<Customer> findCustomersByByRegion(Region region);
    List<Customer> findCustomersByName(String name);
    List<Customer> findAllCustomers();
    Customer createCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);

}
