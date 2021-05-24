package com.example.mongoInvoice.api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Document(collection = "invoice")

public class Invoice {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id_invoice")
	private Integer idInvoice;
	
	@Column(name = "invoice_code")
	@JsonProperty("invoice_code")
	@NotNull(message="invoice code is required!")
	private Integer invoiceCode;
	
	@Column(name = "customer_code")
	@JsonProperty("customer_code")
	@NotNull(message="customer code is required!")
	private Integer customerCode;

	@JsonProperty("subtotal")
	@NotNull(message="subtotal is required!")
	private Double subtotal;
	
	@JsonProperty("taxes")
	@NotNull(message="taxes are required!")
	private Double taxes;
	
	@Column(name = "created_at")
	@JsonProperty("created_at")
	@NotNull(message="creation date is required!")
	private LocalDate createdAt;
	
	@NotNull(message="status is required!")
	private Integer status;
	
	@JsonProperty("invoice_items")
	@NotNull(message="invoice items are required!")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_invoice")
	private List<InvoiceItem> invoiceItems;

	public Integer getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
	}

	public Integer getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(Integer invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public Integer getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Integer customerCode) {
		this.customerCode = customerCode;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
	
	
	
}
