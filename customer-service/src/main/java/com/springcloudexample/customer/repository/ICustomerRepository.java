package com.springcloudexample.customer.repository;

import com.springcloudexample.customer.Entity.Customer;
import com.springcloudexample.customer.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustumerById(Long id);
    List<Customer> findCustomerByRegion(Region region);
    List<Customer> findCustomerByLastName(String name);


}
