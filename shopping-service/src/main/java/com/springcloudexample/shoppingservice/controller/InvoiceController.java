package com.springcloudexample.shoppingservice.controller;

import com.springcloudexample.shoppingservice.entity.Invoice;
import com.springcloudexample.shoppingservice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> findAllInvoces() {
        List<Invoice> invoices = invoiceService.findAllInvoces();

        if (invoices == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(invoices);
    }
}
