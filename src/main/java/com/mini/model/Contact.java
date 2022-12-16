package com.mini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_INFO")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private String activeSw;
}