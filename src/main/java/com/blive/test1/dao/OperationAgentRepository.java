package com.blive.test1.dao;

import com.blive.test1.model.Operation;
import com.blive.test1.model.OperationAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationAgentRepository extends JpaRepository<OperationAgent, Long> {

}
