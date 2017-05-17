package com.rueggerllc.security;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

public class AppUser {


	private static final long serialVersionUID = 103589672841204179L;
	@XmlAttribute
	protected String id;
	@XmlAttribute
	protected String lastName;
	@XmlAttribute
	protected String firstName;
	@XmlAttribute
	protected String middleInitials;
	@XmlAttribute
	protected String title;
	@XmlAttribute
	private String displayName;
	@XmlTransient
	private String accessCode;
	@XmlAttribute
	private boolean rightOfAccessAccepted;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitials() {
		return middleInitials;
	}

	public void setMiddleInitials(String middleInitials) {
		this.middleInitials = middleInitials;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "MhpUser id=[" + id + "] lastname=[" + lastName + "] firstname=[" + firstName + "] middle=[" + middleInitials + "] title=[" + title + "]";
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public void setRightOfAccessAccepted(boolean rightOfAccessAccepted) {
		this.rightOfAccessAccepted = rightOfAccessAccepted;
	}
	}
