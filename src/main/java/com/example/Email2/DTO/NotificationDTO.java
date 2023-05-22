package com.example.Email2.DTO;

public class NotificationDTO {
	private int contactId;
	private String title;
	private String text;
	
	public NotificationDTO() {
	}
	
	public NotificationDTO(int contactId, String title, String text) {
		this.contactId = contactId;
		this.title = title;
		this.text = text;
	}
	
	public int getContactId() {
		return contactId;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
