package com.springcloudexample.shoppingservice.repository;

import com.springcloudexample.shoppingservice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findInvoiceById(Long id);
    List<Invoice> findInvoiceByCustomerId(Long id);

}
