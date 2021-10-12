package com.blive.test1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.blive.test1.dao.AgentRepository;
import com.blive.test1.dao.ClientRepository;
import com.blive.test1.dao.OperateurRepository;
import com.blive.test1.dao.OperationRepository;
import com.blive.test1.model.Agent;
import com.blive.test1.model.Client;
import com.blive.test1.model.Operateur;
import com.blive.test1.model.Operation;

@Controller
public class TheController {

	@Autowired
	private OperateurRepository operateurRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;

	@GetMapping("/listOperateur")
	public String viewOperateurPage(Model model) {
		List<Operateur> listOperateurs = operateurRepository.findAll();
         model.addAttribute("listOperateurs", listOperateurs);
		
        return "listOperateur";
	}
        @GetMapping("/listAgent")
    	public String viewAgentPage(Model model) {
        	List<Agent> listAgents = agentRepository.findAll();
             model.addAttribute("listAgents", listAgents);
    		
            return "listAgent";

        }
        
        @GetMapping("/listClient")
    	public String viewClientPage(Model model) {
    		List<Client> listClients = clientRepository.findAll() ;
             model.addAttribute("listClients", listClients);
    		
            return "listClient";
    	}
        
        @GetMapping("/listOperation")
    	public String viewOperationPage(Model model) {
    		List<Operation> listOperations= operationRepository.findAll() ;
             model.addAttribute("listOperations", listOperations);
             List<Client> listClients = clientRepository.findAll() ;
             model.addAttribute("listClients", listClients);
             List<Agent> listAgents = agentRepository.findAll();
             model.addAttribute("listAgents", listAgents);
    		
            return "listOperation";
    	}
        @GetMapping("/Agent/new")
	    public String showNewAgentForm(Model model) {
	        // create model attribute to bind form data
			Agent agent= new Agent();
	        model.addAttribute("agent", agent);
	        List<Operateur> listOperateurs= operateurRepository.findAll();
	        model.addAttribute("listOperateurs", listOperateurs);
	        return "NewAgent";
        }
        @GetMapping("/Operateur/new")
	    public String showNewOperateurForm(Model model) {
	        // create model attribute to bind form data
        	Operateur operateur= new Operateur();
	        model.addAttribute("operateur", operateur);
	        return "NewOperateur";
        }
        @GetMapping("/Client/new")
	    public String showNewClientForm(Model model) {
	        // create model attribute to bind form data
        	Client client= new Client();
	        model.addAttribute("client", client);
	        return "NewClient";
        }
        @GetMapping("/Operation/new")
	    public String showNewOperationForm(Model model) {
	        // create model attribute to bind form data
        	Operation operation= new Operation();
	        model.addAttribute("operation", operation);
	        List<Client> listClients = clientRepository.findAll() ;
            model.addAttribute("listClients", listClients);
            List<Agent> listAgents = agentRepository.findAll();
            model.addAttribute("listAgents", listAgents);
            
	        return "NewOperation";
        }
        
        @PostMapping("/operateur/save")
        public String saveOperateur(@ModelAttribute("operateur") Operateur operateur) {
            // save user to database
        	operateurRepository.save(operateur);
            return "redirect:/listOperateur";
        }
        @PostMapping("/agent/save")
        public String saveAgent(@ModelAttribute("agent") Agent agent) {
            // save user to database
        	agentRepository.save(agent);
            return "redirect:/listAgent";
        }        

        @PostMapping("/client/save")
        public String saveClient(@ModelAttribute("client") Client client) {
            // save user to database
        	clientRepository.save(client);
            return "redirect:/listClient";
        }
        @PostMapping("/operation/save")
        public String saveOperation(@ModelAttribute("operation") Operation operation) {
            // save user to database
        	System.out.println(operation);
        	//int act;
	    	 Agent ag = operation.getAgent();
	    	 Client cl = operation.getClient();
    	      int act = ag.getCompte()-operation.getMontant();
    	      int rech = cl.getCompte()+operation.getMontant();
    	     ag.setCompte(act);
    	     cl.setCompte(rech);
	    	 agentRepository.save(ag);
	    	 clientRepository.save(cl);
        	 operationRepository.save(operation);
            return "redirect:/listOperation";
        }
        @GetMapping("/agent/update/{idagent}")
	    public String showFormForUpdateAgent(@PathVariable(value = "idagent") long idagent, Model model) {

	        // get Agent from the service
	        Agent agent= agentRepository.findById(idagent).get();

	        // set agent as a model attribute to pre-populate the form
	        model.addAttribute("agent", agent);
	        List<Operateur> listOperateurs= operateurRepository.findAll();
	        model.addAttribute("listOperateurs", listOperateurs);
	        
	        return "NewAgent";
	    }
        @GetMapping("/operateur/update/{idoperateur}")
	    public String showFormForUpdateOperateur(@PathVariable(value = "idoperateur") long idoperateur, Model model) {

	        // get operateur from the service
	        Operateur operateur= operateurRepository.findById(idoperateur).get();

	        // set user as a model attribute to pre-populate the form
	        model.addAttribute("operateur", operateur);
	        return "NewOperateur";
	    }
        @GetMapping("/client/update/{idclient}")
	    public String showFormForUpdateClient(@PathVariable(value = "idclient") long idclient, Model model) {

	        // get operateur from the service
	        Client client= clientRepository.findById(idclient).get();

	        // set user as a model attribute to pre-populate the form
	        model.addAttribute("client", client);
	        return "NewClient";
	    }
        @GetMapping("/operation/update/{id}")
	    public String showFormForUpdateOperation(@PathVariable(value = "id") Long id , Model model) {
//            @GetMapping("/operation/update/?idagent={idagent}&idclient={idclient}")
//    	    public String showFormForUpdateOperation(@RequestParam(value = "idagent") long idagent,@RequestParam(value = "idclient") long idclient, Model model) {

	        // get operateur from the service
        	Operation operation= operationRepository.findById(id).get();
	        // set user as a model attribute to pre-populate the form
	        model.addAttribute("operation", operation);
	        List<Client> listClients = clientRepository.findAll() ;
            model.addAttribute("listClients", listClients);
            List<Agent> listAgents = agentRepository.findAll();
            model.addAttribute("listAgents", listAgents);
            
	        return "NewOperation";
	    }


	    @GetMapping("/agent/delete/{idagent}")
	    public String deleteAgent(@PathVariable(value = "idagent") Long idagent, Model model) {

	        // call delete Agent method 
	        agentRepository.deleteById(idagent);
	        return "redirect:/listAgent";
	    }
	    
	    @GetMapping("/operateur/delete/{idoperateur}")
	    public String deleteOperateur(@PathVariable(value = "idoperateur") long idoperateur, Model model) {

	        // call delete Module method 
	    	operateurRepository.deleteById(idoperateur);
	        return "redirect:/listOperateur";
	    }
	    @GetMapping("/client/delete/{idclient}")
	    public String deleteClient(@PathVariable(value = "idclient") long idclient, Model model) {

	        // call delete Module method 
	    	clientRepository.deleteById(idclient);
	        return "redirect:/listClient";
	    }
	    @GetMapping("/operation/delete/{id}")
	    public String deleteOperation(@PathVariable(value = "id") long id, Model model) {

	        // call delete Module method 
	    	operationRepository.deleteById(id);
	        return "redirect:/listOperation";
	    }
      

        
        }
