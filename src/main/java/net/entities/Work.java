package net.entities;


public class Work {
	private String work_id;
	private String work_name;
	private String work_start;
	private String work_end;
	private int work_percent;
	private String work_status;
	private String user_id;
	
	public Work() {
	}
	public Work(String work_id, String work_name, String work_start, String work_end, int work_percent,
			String work_status, String user_id) {
		this.work_id = work_id;
		this.work_name = work_name;
		this.work_start = work_start;
		this.work_end = work_end;
		this.work_percent = work_percent;
		this.work_status = work_status;
		this.user_id = user_id;
	}
	public String getWork_id() {
		return work_id;
	}
	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}
	public String getWork_start() {
		return work_start;
	}
	public void setWork_start(String work_start) {
		this.work_start = work_start;
	}
	public String getWork_end() {
		return work_end;
	}
	public void setWork_end(String work_end) {
		this.work_end = work_end;
	}
	public int getWork_percent() {
		return work_percent;
	}
	public void setWork_percent(int work_percent) {
		this.work_percent = work_percent;
	}
	public String getWork_status() {
		return work_status;
	}
	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
