package com.sartori.dsVendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sartori.dsVendas.dto.SaleDTO;
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

}
