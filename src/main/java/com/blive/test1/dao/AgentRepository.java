package com.blive.test1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blive.test1.model.Agent;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
	
//	List<Agent> finfByLevel(int level);
//	void updateAgentSetCompteForOperationNative() {
//		
//		
//	};

}
