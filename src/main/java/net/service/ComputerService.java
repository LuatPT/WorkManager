package net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dao.ComputerDao;
import net.entities.Computer;

@Service
@Transactional
public class ComputerService {
	@Autowired
	private ComputerDao computerDao;
	
	public List<Computer> findAll (){
		return computerDao.findAll();
	}
	public Computer findById (int computer_id) {
		return computerDao.findById(computer_id);
	}
	
	public void save (Computer computer) {
		computerDao.save(computer);
	}
	
	public void update(Computer computer) {
		computerDao.update(computer);
	}
	
	public void delete(int computer_id){
		computerDao.delete(computer_id);
	}
}
