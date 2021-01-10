package com.poised;

/**
 * Class used to describe a person
 * @author Kushal
 *
 */
public class Person {
	//variables
	int projectNo;
	String name, telephoneNumber, emailAddress, physicalAddress;
	
	/**
	 * @param projectNo
	 * @param name
	 * @param telephoneNumber
	 * @param emailAddress
	 * @param physicalAddress
	 */
	//contstructor
	public Person(int projectNo, String name, String telephoneNumber, String emailAddress, String physicalAddress) {
		this.projectNo = projectNo;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}
	/**
	 * get project number
	 * @return projectNo
	 */
	public int getProjectNumber() {
		return projectNo;
	}
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * get Telephone Number
	 * @return telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	/**
	 * get Email Address
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * get physical Address
	 * @return physical Address
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	@Override
	public String toString() {
		return " [project No=" + projectNo + ", name=" + name + ", telephone Number=" + telephoneNumber
				+ ", email Address=" + emailAddress + ", physical Address=" + physicalAddress + "]";
	}
	
	
	
	
	

}
