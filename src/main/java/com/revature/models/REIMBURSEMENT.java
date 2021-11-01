package com.revature.models;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class REIMBURSEMENT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reimbID;
	private int amount;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date submitted;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolved;
	private String description;
	//private byTea receipt;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="usersID")
	private USERS author;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private USERS resolver;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimbStatusID")
	private REIMBURSEMENT_STATUS status;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reimbTypeID")
	private REIMBURSEMENT_TYPE type;
	
	
	public REIMBURSEMENT(int reimbID, int amount, Date submitted, Date resolved, String description, USERS author,
			USERS resolver, REIMBURSEMENT_STATUS status, REIMBURSEMENT_TYPE type) {
		super();
		this.reimbID = reimbID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public REIMBURSEMENT(int amount, Date submitted, Date resolved, String description, USERS author, USERS resolver,
			REIMBURSEMENT_STATUS status, REIMBURSEMENT_TYPE type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}


	public REIMBURSEMENT() {
		super();
	}


	public int getReimbID() {
		return reimbID;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Date getSubmitted() {
		return submitted;
	}


	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}


	public Date getResolved() {
		return resolved;
	}


	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public USERS getAuthor() {
		return author;
	}


	public void setAuthor(USERS author) {
		this.author = author;
	}


	public USERS getResolver() {
		return resolver;
	}


	public void setResolver(USERS resolver) {
		this.resolver = resolver;
	}


	public REIMBURSEMENT_STATUS getStatus() {
		return status;
	}


	public void setStatus(REIMBURSEMENT_STATUS status) {
		this.status = status;
	}


	public REIMBURSEMENT_TYPE getType() {
		return type;
	}


	public void setType(REIMBURSEMENT_TYPE type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimbID;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		REIMBURSEMENT other = (REIMBURSEMENT) obj;
		if (amount != other.amount)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "REIMBURSEMENT [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}
	
	
	
      
}
