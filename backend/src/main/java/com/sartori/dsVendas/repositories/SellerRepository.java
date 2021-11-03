package com.sartori.dsVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sartori.dsVendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
