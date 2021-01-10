package com.poised;

import java.util.Date;

/**
 * Class for project used to create a project
 * @author Kushal
 *
 */
public class Project {
	// variable decelrations
	int projectNo;
	String projectName, buildingType, physicalAddress, ERF;
	double totalCharge, totalPaidToDate;
	Date deadlineDate;

	/**
	 * @param projectNo
	 * @param projectName
	 * @param buildingType
	 * @param physicalAddress
	 * @param eRF
	 * @param totalCharge
	 * @param totalPaidToDate
	 * @param deadlineDate
	 * Sole constructor to create a project
	 */
	public Project(int projectNo, String projectName, String buildingType, String physicalAddress, String eRF,
			double totalCharge, double totalPaidToDate, Date deadlineDate) {
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.physicalAddress = physicalAddress;
		ERF = eRF;
		this.totalCharge = totalCharge;
		this.totalPaidToDate = totalPaidToDate;
		this.deadlineDate = deadlineDate;
	}

	/**
	 * Default constructor
	 */
	public Project() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * get project number
	 * @return projectNo
	 */
	public int getProjectNo() {
		return projectNo;
	}
	/**
	 * get project name
	 * @return get project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * get building type
	 * @return getBuildingType
	 */
	public String getBuildingType() {
		return buildingType;
	}

	/**
	 * get physical address
	 * @return getPhysicalAddress
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	/**
	 * get erf number
	 * @return getERF
	 */
	public String getERF() {
		return ERF;
	}

	/**
	 * get total charge
	 * @return getTotalCharge
	 */
	public double getTotalCharge() {
		return totalCharge;
	}

	/**
	 * get total paid to date
	 * @return getTotalPaidToDate
	 */
	public double getTotalPaidToDate() {
		return totalPaidToDate;
	}

	/**
	 * get the deadline date
	 * @return getDeadlineDate
	 */
	public Date getDeadlineDate() {
		return deadlineDate;
	}

}
