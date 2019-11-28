package com.softvision.skill_matrix_api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Version")
	private Long version;

	@Column(name = "DNI")
	private Long dni;

	@Column(name = "Status")
	private Long status;

	//Gets de complete consultant data - Insert and Update only the RecruiterId on Candidates table
	// By there is not cascading
	@OneToOne
	@JoinColumn(name = "RecruiterId")
	private Consultant consultant;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "CreatedDate")
	private Date createdDate;

	@Column(name = "LastModifiedDate")
	private Date lastModifiedDate;

	@Column(name = "LastModifiedBy")
	private String lastModifiedBy;

	@Column(name = "Name")
	private String name;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "EmailAddress")
	private String emailAddress;

	@Column(name = "LinkedInProfile")
	private String linkedInProfile;

	@Column(name = "AdditionalInformation")
	private String additionalInformation;

	@Column(name = "EnglishLevel")
	private String englishLevel;

	public Candidate() {
		super();
	}

	public Candidate(Long version, Long dni, Long status, String createdBy, Date createdDate, Date lastModifiedDate,
			String lastModifiedBy, String name, String lastName, String phoneNumber, String emailAddress,
			String linkedInProfile, String additionalInformation, String englishLevel) {
		super();

		this.version = version;
		this.dni = dni;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.linkedInProfile = linkedInProfile;
		this.additionalInformation = additionalInformation;
		this.englishLevel = englishLevel;
	}

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

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLinkedInProfile() {
		return linkedInProfile;
	}

	public void setLinkedInProfile(String linkedInProfile) {
		this.linkedInProfile = linkedInProfile;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
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

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", version=" + version + ", dni=" + dni + ", status=" + status + ", consultant="
				+ consultant + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", name=" + name + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", linkedInProfile="
				+ linkedInProfile + ", additionalInformation=" + additionalInformation + ", englishLevel="
				+ englishLevel + "]";
	}

}
