package net.entities;


public class Computer {
	private String computer_id;
	private String computer_status;
	private String bill_id;
	
	public Computer() {
	}
	public Computer(String computer_id, String computer_status, String bill_id) {
		this.computer_id = computer_id;
		this.computer_status = computer_status;
		this.bill_id = bill_id;
	}
	public String getComputer_id() {
		return computer_id;
	}
	public void setComputer_id(String computer_id) {
		this.computer_id = computer_id;
	}
	public String getComputer_status() {
		return computer_status;
	}
	public void setComputer_status(String computer_status) {
		this.computer_status = computer_status;
	}
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	
}
