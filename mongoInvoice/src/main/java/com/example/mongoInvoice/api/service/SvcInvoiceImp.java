package com.example.mongoInvoice.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.mongoInvoice.api.entity.Invoice;
import com.example.mongoInvoice.api.repository.RepoInvoice;
import com.example.mongoInvoice.ex.exceptionalHandling.ApiException;

@Service
public class SvcInvoiceImp implements SvcInvoice {
	
	@Autowired
	RepoInvoice repo;

	@Override
	public List<Invoice> getInvoices(){
		try {
			return repo.findAll();
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}

	@Query
	@Override
	public Optional<Invoice> getInvoice(Integer id){
		try {
			return repo.findByIdInvoice(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}

	@Override
	public void createInvoice(Invoice invoice) {
		try {
			repo.save(invoice);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		}
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		try {
			repo.save(invoice);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteInvoice(Integer id) {
		try {
			repo.deleteById(id);
		}catch(Exception e) {
			throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		}
	}
}
