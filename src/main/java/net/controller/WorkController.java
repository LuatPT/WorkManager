package net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.entities.Work;
import net.service.WorkService;

@Controller
public class WorkController {
	@Autowired 
	private WorkService workService;
	
	@RequestMapping(value = {"/", "showListWork"})
	public String showListWork(Model model) {
		 model.addAttribute("listWork", workService.findAll());
		 return "workList";
	}
	@RequestMapping(value = {"/showListWork/{user_id}"})
	public String showListWorkByUser(@PathVariable String user_id, Model model) {
		 model.addAttribute("listWork", workService.findListByUser(user_id));
		 return "workList";
	}
	@RequestMapping("/showAddWork")
	public String showAddWork(Model model){
		model.addAttribute("work", new Work());
		return "workAdd";
	}
	@RequestMapping("/viewWork/{work_id}")
	public String viewWork(@PathVariable String work_id, Model model) {
		Work work = workService.findById(work_id);
		model.addAttribute("work", work);
		return "workView";
	}
	 @RequestMapping("/showUpdateWork/{work_id}")
	  public String showUpdateWork(@PathVariable String work_id, Model model) {
		 Work work = workService.findById(work_id);
	    model.addAttribute("work", work);
	    return "workUpdate";
	  }
	  @RequestMapping("/doSaveWork")
	  public String doSavework(@ModelAttribute("work") Work work, Model model) {
	    workService.save(work);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }
	  @RequestMapping("/doUpdateWork")
	  public String doUpdatework(@ModelAttribute("work") Work work, Model model) {
	    workService.update(work);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }
	  
	  @RequestMapping("/updateStatus")
	  public String updateStatus ( @RequestParam("work_id") String work_id) {
	    workService.updateStatus("Done", work_id);
	    return "";
	  }
	  
	  @RequestMapping("/doDeleteWork/{work_id}")
	  public String doDeletework(@PathVariable String work_id, Model model) {
	    workService.delete(work_id);
	    model.addAttribute("listWork", workService.findAll());
	    return "workList";
	  }

}
