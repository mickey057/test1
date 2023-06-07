package com.blive.test1.controller;

import com.blive.test1.dao.*;
import com.blive.test1.model.*;
import com.blive.test1.model.Module;
import com.blive.test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@ComponentScan(basePackageClasses = OperationAgentController.class)
public class OperationAgentController {
	
	@Autowired
	private AgentRepository agentRepository;

	@Autowired
	private ConfoperRepository confoperRepository;

	@Autowired
	private OperationAgentRepository operationAgentRepository;

	@Autowired
	private OperateurRepository operateurRepository;


//	public void performRecursiveOperation(Agent agent) {
//		// Retrieve the configuration for the operation
//		Confoper confoper = confoperRepository.findById(agent.getAgentprofile().getIdconf()).orElse(null);
//
//		if (confoper != null) {
//			// Perform the operation for the current agent
//			OperationAgent operation = new OperationAgent();
//			operation.setDate(/* Set the date for the operation */);
//			operation.setMontant(/* Set the amount for the operation */);
//			operation.setType(/* Set the type of the operation */);
//			operation.setAgent(agent);
//			operationAgentRepository.save(operation);
//
//			// Check if the agent has sub-agents
//			List<Agent> subAgents = agent.getSubAgent();
//			if (subAgents != null) {
//				for (Agent subAgent : subAgents) {
//					// Recursively perform the operation for each sub-agent
//					performRecursiveOperation(subAgent);
//				}
//			}
//		}
//	}

	public void purchaseCredit(Long buyerId, int amount){
		Agent buyer = agentRepository.findById(buyerId).orElse(null);
		Agent superiorAgent = buyer != null ? buyer.getManagerid() : null;
		if (buyer != null && superiorAgent != null && amount <= buyer.getMontant()) {
			buyer.setMontant(buyer.getMontant() - amount);
			buyer.setCompte(buyer.getCompte() + amount);
			superiorAgent.setMontant(buyer.getMontant() + amount);
			superiorAgent.setCompte(buyer.getCompte() - amount);
		}

	}
	public void purchaseCreditOnLevel(Long buyerId, int amount)
	{
		Agent buyer = agentRepository.findById(buyerId).orElse(null);
		Agent superiorAgent = buyer != null ? buyer.getManagerid() : null;
		if (buyer != null && superiorAgent != null && amount <= buyer.getMontant()) {
			int newamount =0;
			if (buyer.getLevel() - 1 >= 1) {
				newamount = amount - buyer.getConf().getCommision_value();
				buyer.setMontant(buyer.getMontant() - newamount);
				buyer.setCompte(buyer.getCompte() + amount);
				superiorAgent.setMontant(buyer.getMontant() + newamount);
				superiorAgent.setCompte(buyer.getCompte() - amount);
			}
			else {
				System.out.println("This agent Is on top level");
			}

		}
	}

	@PostMapping("/agent/operation/{idagent}")
	public String TransfertCreditForm (@PathVariable(value = "idagent") Long buyerId, int amount, Model model)
	{
		// get Agent from the service
		Agent agent= agentRepository.findById(buyerId).get();
		OperationAgent op = new OperationAgent();
		op.setAgent2(agent);
		op.setAgent1(agent.managerid);

		// set agent as a model attribute to pre-populate the form
		model.addAttribute("agent", agent);
		List<Operateur> listOperateurs= operateurRepository.findAll();
		model.addAttribute("listOperateurs", listOperateurs);


		//purchaseCredit(buyerId,amount);
		return "TransfertForm";
	}

	
}