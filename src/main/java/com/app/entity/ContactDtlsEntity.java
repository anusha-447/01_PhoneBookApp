package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="contact_dtl")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name="contact_id")
	private Integer cntctid;
	@Column(name="contact_name")
	private String cntctname;
	@Column(name="contact_num")
	private String cntctnum;
	@Column(name="contact_mail")
	private String cntctmail;
	

}
