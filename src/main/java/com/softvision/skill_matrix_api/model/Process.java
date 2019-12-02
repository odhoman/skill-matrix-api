package com.softvision.skill_matrix_api.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@Column(name = "ActualSalary")
	private BigDecimal actualSalary;

	@Column(name = "WantedSalary")
	private BigDecimal wantedSalary;

	@Column(name = "EnglishLevel")
	private String englishLevel;

	@Column(name = "Seniority")
	private String seniority;

	// Read - Insert - Update only the RecruiterId on Candidates table
	@OneToOne
	@JoinColumn(name = "CandidateId")
	private Candidate candidate;

	// Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne
	@JoinColumn(name = "ConsultantOwnerId")
	private Consultant consultantOwner;

	// Read - Insert - Update only the ConsultantDelegateId on Consultants table
	@OneToOne
	@JoinColumn(name = "ConsultantDelegateId")
	private Consultant consultantDelegate;
	
	@OneToMany(mappedBy = "process")
	private List<Stage> stages;

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

	public BigDecimal getActualSalary() {
		return actualSalary;
	}

	public void setActualSalary(BigDecimal actualSalary) {
		this.actualSalary = actualSalary;
	}

	public BigDecimal getWantedSalary() {
		return wantedSalary;
	}

	public void setWantedSalary(BigDecimal wantedSalary) {
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
	
	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", version=" + version + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", endDate=" + endDate + ", startDate=" + startDate + ", status=" + status + ", profile=" + profile
				+ ", rejectionReason=" + rejectionReason + ", actualSalary=" + actualSalary + ", wantedSalary="
				+ wantedSalary + ", englishLevel=" + englishLevel + ", seniority=" + seniority + ", candidate="
				+ candidate + ", consultantOwner=" + consultantOwner + ", consultantDelegate=" + consultantDelegate
				+ ", processes=" + stages + "]";
	}

}
