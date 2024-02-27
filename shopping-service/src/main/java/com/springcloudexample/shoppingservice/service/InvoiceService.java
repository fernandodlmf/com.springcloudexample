package com.springcloudexample.shoppingservice.service;

import com.springcloudexample.shoppingservice.entity.Invoice;
import com.springcloudexample.shoppingservice.repository.IInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService{

    private IInvoiceRepository repository;

    @Override
    public List<Invoice> findAllInvoces() {
        return repository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = repository.findInvoiceById(invoice.getId());

        if (invoiceDB == null)
            return null;
        invoiceDB.setStatus("DELETADO");
        return repository.save(invoiceDB);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = repository.findInvoiceById(invoice.getId());

        if(invoiceDB == null)
            return null;

        invoice.setStatus("UPDATED");
        return repository.save(invoice);
    }

    @Override
    public Invoice findInvoiceById(Long id) {
        return repository.findInvoiceById(id);
    }

    @Override
    public List<Invoice> findInvoiceByCustomerId(Long id) {
        return repository.findInvoiceByCustomerId(id);
    }
}
