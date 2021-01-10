package com.poised;


import java.util.Date;

/**
 * This is a class used to match the values that are coming from the file that stores the current project details
 * @author Kushal
 *
 */
public class saveProject {

	
	String projectName;
	String buildingType;
	String projectAddress;
	String erfNumber;
	double projectPrice;
	double projectAmountPaidToDate;
	Date deadlineDate;
	
	String contractorName;
	String contractorTelephoneNumber;
	String contractorEmailAddress;
	String contractorPhysicalAddress;
	
	String architectName;
	String architectTelephoneNumber;
	String architectEmailAddress;
	String architectPhysicalAddress;
	
	String customerName;
	String customerTelephoneNumber;
	String customerEmailAddress;
	String customerPhysicalAddress;
	/**
	 * @param projectName
	 * @param buildingType
	 * @param projectAddress
	 * @param erfNumber
	 * @param projectPrice
	 * @param projectAmountPaidToDate
	 * @param deadlineDate
	 * @param contractorName
	 * @param contractorTelephoneNumber
	 * @param contractorEmailAddress
	 * @param contractorPhysicalAddress
	 * @param architectName
	 * @param architectTelephoneNumber
	 * @param architectEmailAddress
	 * @param architectPhysicalAddress
	 * @param customerName
	 * @param customerTelephoneNumber
	 * @param customerEmailAddress
	 * @param customerPhysicalAddress
	 * 
	 * Sole constructor. constructor the create the projects from the text file (For invocation by subclass constructors, typically implicit.)
	 */
	public saveProject(String projectName, String buildingType, String projectAddress, String erfNumber,
			double projectPrice, double projectAmountPaidToDate, Date deadlineDate, String contractorName,
			String contractorTelephoneNumber, String contractorEmailAddress, String contractorPhysicalAddress,
			String architectName, String architectTelephoneNumber, String architectEmailAddress,
			String architectPhysicalAddress, String customerName, String customerTelephoneNumber,
			String customerEmailAddress, String customerPhysicalAddress) {
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.erfNumber = erfNumber;
		this.projectPrice = projectPrice;
		this.projectAmountPaidToDate = projectAmountPaidToDate;
		this.deadlineDate = deadlineDate;
		this.contractorName = contractorName;
		this.contractorTelephoneNumber = contractorTelephoneNumber;
		this.contractorEmailAddress = contractorEmailAddress;
		this.contractorPhysicalAddress = contractorPhysicalAddress;
		this.architectName = architectName;
		this.architectTelephoneNumber = architectTelephoneNumber;
		this.architectEmailAddress = architectEmailAddress;
		this.architectPhysicalAddress = architectPhysicalAddress;
		this.customerName = customerName;
		this.customerTelephoneNumber = customerTelephoneNumber;
		this.customerEmailAddress = customerEmailAddress;
		this.customerPhysicalAddress = customerPhysicalAddress;
	}
	/**
	 * get the project name
	 * @return the projectName 
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * set the project name
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * get the building type
	 * @return the buildingType
	 */
	public String getBuildingType() {
		return buildingType;
	}
	/**
	 * set the building type
	 * @param buildingType the buildingType to set
	 */
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	/**
	 * get the project address
	 * @return the projectAddress
	 */
	public String getProjectAddress() {
		return projectAddress;
	}
	/**
	 * set the project address
	 * @param projectAddress the projectAddress to set
	 */
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	/**
	 * get the erf number
	 * @return the erfNumber
	 */
	public String getErfNumber() {
		return erfNumber;
	}
	/**
	 * set the erf number
	 * @param erfNumber the erfNumber to set
	 */
	public void setErfNumber(String erfNumber) {
		this.erfNumber = erfNumber;
	}
	/**
	 * get the project price
	 * @return the projectPrice
	 */
	public double getProjectPrice() {
		return projectPrice;
	}
	/**
	 * set the project price
	 * @param projectPrice the projectPrice to set
	 */
	public void setProjectPrice(double projectPrice) {
		this.projectPrice = projectPrice;
	}
	/**
	 * get project amount paid to date
	 * @return the projectAmountPaidToDate
	 */
	public double getProjectAmountPaidToDate() {
		return projectAmountPaidToDate;
	}
	/**
	 * set the project amount paid to date
	 * @param projectAmountPaidToDate the projectAmountPaidToDate to set
	 */
	public void setProjectAmountPaidToDate(double projectAmountPaidToDate) {
		this.projectAmountPaidToDate = projectAmountPaidToDate;
	}
	/**
	 * get the deadline date
	 * @return the deadlineDate
	 */
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	/**
	 * set the deadline date
	 * @param deadlineDate the deadlineDate to set
	 */
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	/**
	 * get the contractor name
	 * @return the contractorName
	 */
	public String getContractorName() {
		return contractorName;
	}
	/**
	 * set the contractor name
	 * @param contractorName the contractorName to set
	 */
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	/**
	 * get the contractor telephone number
	 * @return the contractorTelephoneNumber
	 */
	public String getContractorTelephoneNumber() {
		return contractorTelephoneNumber;
	}
	/**
	 * set the contractor telephone number
	 * @param contractorTelephoneNumber the contractorTelephoneNumber to set
	 */
	public void setContractorTelephoneNumber(String contractorTelephoneNumber) {
		this.contractorTelephoneNumber = contractorTelephoneNumber;
	}
	/**
	 * get the contractor email address
	 * @return the contractorEmailAddress
	 */
	public String getContractorEmailAddress() {
		return contractorEmailAddress;
	}
	/**
	 * set the contractor email address
	 * @param contractorEmailAddress the contractorEmailAddress to set
	 */
	public void setContractorEmailAddress(String contractorEmailAddress) {
		this.contractorEmailAddress = contractorEmailAddress;
	}
	/**
	 * get the contractor physical address
	 * @return the contractorPhysicalAddress
	 */
	public String getContractorPhysicalAddress() {
		return contractorPhysicalAddress;
	}
	/**
	 *	set the contractor physical address
	 * @param contractorPhysicalAddress the contractorPhysicalAddress to set
	 */
	public void setContractorPhysicalAddress(String contractorPhysicalAddress) {
		this.contractorPhysicalAddress = contractorPhysicalAddress;
	}
	/**
	 * get arch name
	 * @return the architectName
	 */
	public String getArchitectName() {
		return architectName;
	}
	/**
	 * set arch name
	 * @param architectName the architectName to set
	 */
	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}
	/**
	 * get the arch telephone number
	 * @return the architectTelephoneNumber
	 */
	public String getArchitectTelephoneNumber() {
		return architectTelephoneNumber;
	}
	/**
	 *	set the architect telephone number
	 * @param architectTelephoneNumber the architectTelephoneNumber to set
	 */
	public void setArchitectTelephoneNumber(String architectTelephoneNumber) {
		this.architectTelephoneNumber = architectTelephoneNumber;
	}
	/**
	 * get the architect email address
	 * @return the architectEmailAddress
	 */
	public String getArchitectEmailAddress() {
		return architectEmailAddress;
	}
	/**
	 * set the architect email address
	 * @param architectEmailAddress the architectEmailAddress to set
	 */
	public void setArchitectEmailAddress(String architectEmailAddress) {
		this.architectEmailAddress = architectEmailAddress;
	}
	/**
	 * get the architect physical address
	 * @return the architectPhysicalAddress
	 */
	public String getArchitectPhysicalAddress() {
		return architectPhysicalAddress;
	}
	/**
	 * set arch physical address
	 * @param architectPhysicalAddress the architectPhysicalAddress to set
	 */
	public void setArchitectPhysicalAddress(String architectPhysicalAddress) {
		this.architectPhysicalAddress = architectPhysicalAddress;
	}
	/**
	 * get customer name
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * set customer name
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * get customer telephone number
	 * @return the customerTelephoneNumber
	 */
	public String getCustomerTelephoneNumber() {
		return customerTelephoneNumber;
	}
	/**
	 * set customer telephone number
	 * @param customerTelephoneNumber the customerTelephoneNumber to set
	 */
	public void setCustomerTelephoneNumber(String customerTelephoneNumber) {
		this.customerTelephoneNumber = customerTelephoneNumber;
	}
	/**
	 * get telephone number
	 * @return the customerEmailAddress
	 */
	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}
	/**
	 * set cusotmer email address
	 * @param customerEmailAddress the customerEmailAddress to set
	 */
	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}
	/**
	 * get customer physical address
	 * @return the customerPhysicalAddress
	 */
	public String getCustomerPhysicalAddress() {
		return customerPhysicalAddress;
	}
	/**
	 * set customer phyiscal address
	 * @param customerPhysicalAddress the customerPhysicalAddress to set
	 */
	public void setCustomerPhysicalAddress(String customerPhysicalAddress) {
		this.customerPhysicalAddress = customerPhysicalAddress;
	}
}
