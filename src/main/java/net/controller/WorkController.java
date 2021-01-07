package net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.entities.Work;
import net.service.WorkService;

@Controller
public class WorkController {
	@Autowired 
	private WorkService workService;
	
	@RequestMapping(value = {"/", "work-list"})
	public String listWork(Model model) {
		 model.addAttribute("listWork", workService.findAll());
		 return "workList";
	}
	@RequestMapping(value = {"/work-list/{user_id}"})
	public String listWorkByUser(@PathVariable String user_id, Model model) {
		 model.addAttribute("listWork", workService.findListByUser(user_id));
		 return "workList";
	}
	@RequestMapping("/work-save")
	public String insertWork(Model model){
		model.addAttribute("work", new Work());
		return "workAdd";
	}
	@RequestMapping("/work-view/{work_id}")
	public String viewWork(@PathVariable String work_id, Model model) {
		Work work = workService.findById(work_id);
		model.addAttribute("work", work);
		return "workView";
	}
	 @RequestMapping("/work-update/{work_id}")
	  public String updatework(@PathVariable String work_id, Model model) {
		 Work work = workService.findById(work_id);
	    model.addAttribute("work", work);
	    return "workUpdate";
	  }
	  @RequestMapping("/saveWork")
	  public String doSavework(@ModelAttribute("work") Work work, Model model) {
	    workService.save(work);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }
	  @RequestMapping("/updateWork")
	  public String doUpdatework(@ModelAttribute("work") Work work, Model model) {
	    workService.update(work);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }
	  
	  @RequestMapping("/workDelete/{work_id}")
	  public String doDeletework(@PathVariable String work_id, Model model) {
	    workService.delete(work_id);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }

}
