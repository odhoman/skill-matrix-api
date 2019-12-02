package com.softvision.skill_matrix_api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Stages")
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Version")
	private Long version;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	private Date lastModifiedDate;

	@Column(name = "LastModifiedBy")
	private String lastModifiedBy;

	@Column(name = "Status")
	private Long status;

	@Column(name = "Type")
	private Long type;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Feedback")
	private String feedback;

	@ManyToOne
	@JoinColumn(name = "ProcessId")
	@JsonIgnoreProperties("stages")
	private Process process;

	// Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne
	@JoinColumn(name = "ConsultantOwnerId")
	private Consultant consultantOwner;

	// Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne
	@JoinColumn(name = "ConsultantDelegateId")
	private Consultant consultantDelegate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Consultant getConsultantOwner() {
		return consultantOwner;
	}

	public void setConsultantOwner(Consultant consultantOwner) {
		this.consultantOwner = consultantOwner;
	}

	public Consultant getConsultantDelegate() {
		return consultantDelegate;
	}

	public void setConsultantDelegate(Consultant consultantDelegate) {
		this.consultantDelegate = consultantDelegate;
	}

	@Override
	public String toString() {
		return "Stage [id=" + id + ", version=" + version + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", status=" + status
				+ ", type=" + type + ", date=" + date + ", feedback=" + feedback + "]";
	}

}
