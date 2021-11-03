package com.sartori.dsVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sartori.dsVendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
