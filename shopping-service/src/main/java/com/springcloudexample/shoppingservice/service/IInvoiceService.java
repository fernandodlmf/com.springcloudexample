package com.springcloudexample.shoppingservice.service;

import com.springcloudexample.shoppingservice.entity.Invoice;

import java.util.List;

public interface IInvoiceService {

    List<Invoice> findAllInvoces();
    Invoice createInvoice(Invoice invoice);
    Invoice deleteInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);
    Invoice findInvoiceById(Long id);
    List<Invoice> findInvoiceByCustomerId(Long id);

}
