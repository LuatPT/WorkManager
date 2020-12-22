package net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.entities.Computer;
import net.service.ComputerService;

@Controller
public class ComputerController {
	@Autowired 
	private ComputerService computerService;
	
	@RequestMapping(value = {"/", "computer-list"}, method = RequestMethod.GET)
	public String listComputer(Model model) {
		 model.addAttribute("listComputerAll", computerService.findAll());
		 return "computerList";
	}
	@RequestMapping("/computer-save")
	public String insertComputer(Model model){
		model.addAttribute("computer", new Computer());
		return "computerAdd";
	}
	@RequestMapping("/computer-view/{computer_id}")
	public String viewComputer(@PathVariable int computer_id, Model model) {
		Computer computer = computerService.findById(computer_id);
		model.addAttribute("computer", computer);
		return "computerView";
	}
	 @RequestMapping("/computer-update/{computer_id}")
	  public String updatecomputer(@PathVariable int computer_id, Model model) {
		 Computer computer = computerService.findById(computer_id);
	    model.addAttribute("computer", computer);
	    return "computerUpdate";
	  }
	  @RequestMapping("/saveComputer")
	  public String doSavecomputer(@ModelAttribute("computer") Computer computer, Model model) {
	    computerService.save(computer);
	    model.addAttribute("listComputer", computerService.findAll());
	    return "computerList";
	  }
	  @RequestMapping("/updateComputer")
	  public String doUpdatecomputer(@ModelAttribute("computer") Computer computer, Model model) {
	    computerService.update(computer);
	    model.addAttribute("listComputer", computerService.findAll());
	    return "computerList";
	  }
	  
	  @RequestMapping("/computerDelete/{computer_id}")
	  public String doDeletecomputer(@PathVariable int computer_id, Model model) {
	    computerService.delete(computer_id);
	    model.addAttribute("listComputer", computerService.findAll());
	    return "computerList";
	  }

}
