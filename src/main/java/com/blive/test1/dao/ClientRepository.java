package com.blive.test1.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blive.test1.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
