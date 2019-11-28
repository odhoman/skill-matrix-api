package com.softvision.skill_matrix_api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Processes")
public class Process {

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

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "Status")
	private Long status;

	@Column(name = "Profile")
	private String profile;

	@Column(name = "RejectionReason")
	private String rejectionReason;

	//Read - Insert - Update only the RecruiterId on Candidates table
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "CandidateId")
	private Candidate candidate;

	//Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ConsultantOwnerId")
	private Consultant consultantOwner;

	//Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "ConsultantDelegateId")
	private Consultant consultantDelegate;

	@Column(name = "ActualSalary")
	private Double actualSalary;

	@Column(name = "WantedSalary")
	private Double wantedSalary;

	@Column(name = "EnglishLevel")
	private String englishLevel;

	@Column(name = "Seniority")
	private String seniority;

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Double getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(Double actualSalary) {
		this.actualSalary = actualSalary;
	}

	public Double getWantedSalary() {
		return wantedSalary;
	}

	public void setWantedSalary(Double wantedSalary) {
		this.wantedSalary = wantedSalary;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
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

}
