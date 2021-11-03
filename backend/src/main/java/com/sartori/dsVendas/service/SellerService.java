package com.sartori.dsVendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sartori.dsVendas.dto.SellerDTO;
import com.sartori.dsVendas.entities.Seller;
import com.sartori.dsVendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		
		return result.stream().map(sellerItem -> new SellerDTO(sellerItem)).collect(Collectors.toList());
	}

}
