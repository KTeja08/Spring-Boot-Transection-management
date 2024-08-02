package com.transactionmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transactionmanagement.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
