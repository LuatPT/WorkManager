package net.entities;


public class Computer {
	private int computer_id;
	private String computer_status;
	
	public Computer() {
	}

	public Computer(int computer_id, String computer_status) {
		this.computer_id = computer_id;
		this.computer_status = computer_status;
	}

	public int getComputer_id() {
		return computer_id;
	}

	public void setComputer_id(int computer_id) {
		this.computer_id = computer_id;
	}

	public String getComputer_status() {
		return computer_status;
	}

	public void setComputer_status(String computer_status) {
		this.computer_status = computer_status;
	}
	
}
