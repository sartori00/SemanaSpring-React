package com.sartori.dsVendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sartori.dsVendas.dto.SaleDTO;
import com.sartori.dsVendas.dto.SaleSuccessDTO;
import com.sartori.dsVendas.dto.SaleSumDTO;
import com.sartori.dsVendas.entities.Sale;
import com.sartori.dsVendas.repositories.SaleRepository;
import com.sartori.dsVendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		
		return result.map(saleItem -> new SaleDTO(saleItem));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
