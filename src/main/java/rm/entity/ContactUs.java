package rm.entity;

import java.sql.Date;

public class ContactUs {
	
	private int id;
	private String username;
	private String email;
	private String subject;
	private String message;
	private Date messageDate;
	private String status;
	
	public ContactUs() {
		super();
	}
	public ContactUs(String username, String email, String subject, String message) {
		super();
		this.username = username;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
