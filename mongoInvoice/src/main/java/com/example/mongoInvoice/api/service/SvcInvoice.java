package com.example.mongoInvoice.api.service;

import java.util.List;
import java.util.Optional;

import com.example.mongoInvoice.api.entity.Invoice;

public interface SvcInvoice {

    public List<Invoice> getInvoices();
    public Optional<Invoice> getInvoice(Integer id);
    public void createInvoice(Invoice invoice);
    public void updateInvoice(Invoice invoice);
    public void deleteInvoice(Integer id);
}
