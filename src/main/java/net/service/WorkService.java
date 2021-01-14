package net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dao.WorkDao;
import net.entities.Work;

@Service
@Transactional
public class WorkService {
	@Autowired
	private WorkDao workDao;
	public List<Work> findListByUser (String user_id){
		return workDao.findListByUser(user_id);
	}
	public List<Work> findAll (){
		return workDao.findAll();
	}
	public Work findById (String work_id) {
		return workDao.findById(work_id);
	}
	
	public void save (Work work) {
		workDao.save(work);
	}
	
	public void update(Work work) {
		workDao.update(work);
	}
	
	public void updateStatus(String workStatus, String workId) {
		workDao.updateStatus(workStatus,workId);
	}
	
	public void delete(String work_id){
		workDao.delete(work_id);
	}
}
