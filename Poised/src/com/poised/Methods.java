package com.poised;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This will store methods that will be used in the project
 * @author Kushal Gopee
 *
 */
public class Methods {

	/**
	 * Function to create the number of projects
	 * @param in
	 * @return numberOfProjects - return the number of projects the user wants to input
	 */
	public static int createNumberOfProjects(Scanner in) {
		boolean inputValid = false;
		//init number of projects
		int numberOfProjects = 0;
		
		//while loop
		while (!inputValid) {
			System.out.println("How many projects will you be creating");
			//take user input
			String input = in.nextLine();

			try {
				//assign user input to number of Projects variable
				numberOfProjects = Integer.parseInt(input);
				//if number of projects is less than 0
				//User must enter 1 project min.
				if (numberOfProjects <= 0) {
					System.out.println("You must have 1 project minimum");
					inputValid = false;
				} 
				//user placed a correct number
				else {
					return numberOfProjects;
				}
			} catch (NumberFormatException e) {
				System.out.println("You didn't enter a valid number");

			}

		}
		return numberOfProjects;
	}

	/*
	 * Method to create a project fee
	 * @param in
	 * @param projectFee
	 * @param userMessage = allows to take a user message
	 * 
	 */
	public static double createProjectFee(Scanner in, double projectFee, String userMessage) {
		boolean inputValid;
		inputValid = false;
		
		//Start while loop
		while (!inputValid) {
			System.out.println(userMessage); // show user the message
			String input = in.nextLine(); //take the user message
			
			try {
				//assign project fee
				projectFee = Double.parseDouble(input);
				//if project fee is < 0 
				if (projectFee < 0) {
					System.out.println("Your project cannot cost less than 0");
					inputValid = false;
				} 
				//if project fee > 0
				else {
					inputValid = true;
				}
				// catch number format exception
			} catch (NumberFormatException e) {
				System.out.println("You didn't enter a valid amount");
			}
		}
		return projectFee;
	}

	
	/**
	 * This function allows the user to change the contractor details by the project number
	 * @throws ParseException
	 */
	public static void changeContractorsDetailByProjectNumberFromListOfObjects() {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					
					
					try {
				    project_number = Integer.parseInt(input);
				    //SQL statements
				    String updateCustomer = "UPDATE Contractor SET ContractorName = ?, ContractorTelelphoneNumber = ?, ContractorEmailAddress = ?, contractorPyhsicalAddress = ? WHERE Projectid = ?";
					String getCusomter = "SELECT *  FROM Contractor where projectid = ?";
				    
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getCusomter);
					pst.setInt(1, project_number);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the customer searched for
					else {
						do {
							//get customers from sql
							String currentName = rs.getString("ContractorName");
							String currentTelephoneNumber = rs.getString("ContractorTelelphoneNumber");
							String currentEmailAddress = rs.getString("ContractorEmailAddress");
							String currentPhysicalAddress = rs.getString("ContractorPyhsicalAddress");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							//ask for new infor
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							//update the customer
							try (PreparedStatement psts = connection.prepareStatement(updateCustomer);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		
		

	}
	
	/**
	 * This function allows the user to change the architect details by the project number
	 */
	public static void changeArchitectDetailByProjectNumberFromListOfObjects() {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					
					
					try {
						//project number
				    project_number = Integer.parseInt(input);
				    //SQL statment
				    String updateCustomer = "UPDATE Architect SET ArchitectName = ?, ArchitectTelelphoneNumber = ?, ArchitectEmailAddress = ?, ArchitectPyhsicalAddress = ? WHERE Projectid = ?";
					String getCusomter = "SELECT *  FROM Architect where projectid = ?";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getCusomter);
					pst.setInt(1, project_number);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display searched for details 
					else {
						do {
							String currentName = rs.getString("ArchitectName");
							String currentTelephoneNumber = rs.getString("ArchitectTelelphoneNumber");
							String currentEmailAddress = rs.getString("ArchitectEmailAddress");
							String currentPhysicalAddress = rs.getString("ArchitectPyhsicalAddress");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							//update architect
							try (PreparedStatement psts = connection.prepareStatement(updateCustomer);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		

	}
	
	
	
	/**
	 * This function allows the user to change the customer details by the project number
	 * @param proj = take in the list of project objects
	 * @param numberOfProjects
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void changeCustomerDetailByProjectNumberFromListOfObjects() {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					
					
					try {
				    project_number = Integer.parseInt(input);
				    String updateCustomer = "UPDATE Customer SET CustomerName = ?, CustomerTelelphoneNumber = ?, CustomerEmailAddress = ?, CustomerPyhsicalAddress = ? WHERE Projectid = ?";
					String getCusomter = "SELECT *  FROM customer where projectid = ?";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getCusomter);
					pst.setInt(1, project_number);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("CustomerName");
							String currentTelephoneNumber = rs.getString("CustomerTelelphoneNumber");
							String currentEmailAddress = rs.getString("CustomerEmailAddress");
							String currentPhysicalAddress = rs.getString("CustomerPyhsicalAddress");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							
							try (PreparedStatement psts = connection.prepareStatement(updateCustomer);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		

	}
	
	/**
	 * The following function allows the user to finalise a project by using the project number
	 */
	public static void FinaliseProjectByProjectNumber() {
		Scanner in = new Scanner(System.in);
		int project_number = 0; //init the project number
		boolean inputValid = false; //variable for while loop
		double totalProjectFee = 0d; //total project fee
		double totalAmountPaidToDate = 0d; // total amount due
		double balance = 0d; //total porject balance
		String projectName = "";//for project name
		String customerName ="";
		String customerEmailAddress ="";
		String customerTelephoneNumber ="";
		String customerPhysicalAddress = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //new simple date formatter  
		Date dateCompleted = new Date();  // date completed i.e. date user finalises the project
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					project_number = Integer.parseInt(input);
					
					 try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
									"kushal", "kushal");
							// Create a direct line to the database for running our queries
							Statement statement = connection.createStatement();
							//create a result set
							ResultSet results;
							//SQL Statement to get project still due
							String getProjectByProjectNumber = "Select ProjectName,TotalProjectFee,TotalFeePaidToDate,CustomerName,CustomerTelelphoneNumber,CustomerEmailAddress,CustomerPyhsicalAddress\r\n" + 
									"From Project \r\n" + 
									"INNER JOIN Customer on Project.Projectid = Customer.Projectid\r\n" + 
									"where Project.Projectid= ?";
							String insertCompleted = "Insert into completed(ProjectName, CustomerName, customerTelephoneNumber, CustomerEmailAddress, customerPhysicalAddress) VALUES (?, ?, ?, ?, ?)";
							PreparedStatement pst = connection.prepareStatement(getProjectByProjectNumber);
							pst.setInt(1, project_number);
							ResultSet rs = pst.executeQuery();
							//if no results
							if (rs.next() == false) {
								System.out.println("Invalid choice try again");
							}
							//display the title searched for
							else {
								do {
									//get total due
									totalProjectFee =rs.getDouble("TotalProjectFee");
									totalAmountPaidToDate =rs.getDouble("TotalFeePaidToDate");
									projectName= rs.getString("ProjectName");
									customerName = rs.getString("CustomerName");
									customerEmailAddress = rs.getString("CustomerEmailAddress");
									customerPhysicalAddress = rs.getString("CustomerPyhsicalAddress");
									customerTelephoneNumber = rs.getString("CustomerTelelphoneNumber");
									balance = totalProjectFee - totalAmountPaidToDate; // calculate the balance
									// if the the balance is greater than 0 then print the invice
									if (balance > 0d) { 
										System.out.println("==========INVOICE FOR: "+ projectName +"==========");
										System.out.println("\n");
										System.out.println("Customer Name :" + customerName);
										System.out.println("Customer Email :" + customerEmailAddress);
										System.out.println("Customer Telephone Number :" + customerTelephoneNumber);
										System.out.println("Customer Physical Address :" + customerPhysicalAddress);
										System.out.println("Amount To still be paid R" + balance);
										System.out.println("\n");
										
										//add to finalised table
										try (PreparedStatement pstfinal = connection.prepareStatement(insertCompleted);) {
											pstfinal.setString(1, projectName);
											pstfinal.setString(2, customerName);
											pstfinal.setString(3, customerTelephoneNumber);
											pstfinal.setString(4, customerEmailAddress);
											pstfinal.setString(5, customerPhysicalAddress);
											pstfinal.executeUpdate();
											pstfinal.close();
											System.out.println("project deleted and saved");
										} catch (Exception e) {
											System.out.println("Error saving try again");
											e.printStackTrace();
										}
										
										
										
										//remove finalised project from the list of projects
										String deleteArchitct = "delete from architect where projectid = ?";
										String deleteCustomer = "delete from customer where projectid = ?";
										String deleteContractor = "delete from contractor where projectid = ?";
										String deleteProject = "delete from project where projectid = ?";
										try (PreparedStatement pstdel = connection.prepareStatement(deleteArchitct);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("architect deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteCustomer);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("cusotmer deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteContractor);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("contractor deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteProject);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("project deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}										
										inputValid = true;
										break;
									
										
										
										
										//save the updated project details the file that store the current projects
										
									}
									//if the balance is <= 0 we don't generate an invoice
									else if (balance <= 0d) {
										System.out.println("No Invoice to generate as it has been fully paid");
										//write the detail to the finalised project file including the date completed
										//add to finalised table
										try (PreparedStatement pstfinal = connection.prepareStatement(insertCompleted);) {
											pstfinal.setString(1, projectName);
											pstfinal.setString(2, customerName);
											pstfinal.setString(3, customerTelephoneNumber);
											pstfinal.setString(4, customerEmailAddress);
											pstfinal.setString(5, customerPhysicalAddress);
											pstfinal.executeUpdate();
											pstfinal.close();
											System.out.println("project deleted and saved");
										} catch (Exception e) {
											System.out.println("Error saving try again");
											e.printStackTrace();
										}
										//remove finalised project from the list of projects
										String deleteArchitct = "delete from architect where projectid = ?";
										String deleteCustomer = "delete from customer where projectid = ?";
										String deleteContractor = "delete from contractor where projectid = ?";
										String deleteProject = "delete from project where projectid = ?";
										try (PreparedStatement pstdel = connection.prepareStatement(deleteArchitct);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("architect deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteCustomer);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("cusotmer deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteContractor);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("contractor deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteProject);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("project deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}	
										//remove finalised project from the list of projects
										inputValid = true;
										//save the updated project details the file that store the current projects
										break;
									}
									
									break;
									
									
									
									
								} while (rs.next());
							}
							rs.close();
						}
						catch (SQLException e) {
							// We only want to catch a SQLException - anything else is off-limits for now.
							e.printStackTrace();
						}
			
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
	}


	
	
	
	/**
	 * 
	 * This function allows the user to change the project details by the project number
	 * @throws ParseException for date handling error
	 */
	public static void changeProjectDetailByProjectNumberFromListOfObjects() throws ParseException {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newBuildingName = "";
		String newPhysicalAddress = "";
		String newERF = "";
		String userDate = "";
		double newTotalProjectFee = 0d;
		double newTotalFeePaidToDate = 0d;
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project number ");
				//take user input
				String input = in.nextLine();
				try {
					//assign input to project number
					
					
					try {
				    project_number = Integer.parseInt(input);
				    String updateProject = "UPDATE Project SET ProjectName = ?, BuildingName = ?, PhysicalAddress = ?, ERF = ?, TotalProjectFee =?, TotalFeePaidToDate = ?, UserDate = ? WHERE Projectid = ?";
					String getProject = "SELECT *  FROM Project where projectid = ?";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getProject);
					pst.setInt(1, project_number);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("ProjectName");
							String currentBuldingName = rs.getString("BuildingName");
							String currentAddress = rs.getString("PhysicalAddress");
							String currentERF = rs.getString("ERF");
							Double currentTotalProjectFee = rs.getDouble("TotalProjectFee");
							Double currentTotalFeePaidToDate = rs.getDouble("TotalFeePaidToDate");
							Date currentDate = rs.getDate("UserDate");
							
							System.out.println("current name " + currentName);
							System.out.println("current Bulding Name " + currentBuldingName);
							System.out.println("current Address " + currentAddress);
							System.out.println("current ERF " + currentERF);
							System.out.println("current TotalProject Fee " + currentTotalProjectFee);
							System.out.println("current Total Fee Paid To Date " + currentTotalFeePaidToDate);
							System.out.println("current Due date" + currentDate);
							
							
							System.out.println("Enter new project name");
							newName = in.nextLine();
							System.out.println("Enter new building name");
							newBuildingName = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
							System.out.println("Enter new ERF");
							newERF = in.nextLine();
							newTotalProjectFee = Methods.createProjectFee(in, newTotalProjectFee, "Total fee paid so far e.g. 300.50");
							newTotalFeePaidToDate = Methods.createProjectFee(in, newTotalFeePaidToDate, "Total fee paid so far e.g. 300.50");
							userDate = Methods.createProjectDueDate(in);
						
							
							 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							  java.util.Date utilDate = format.parse(userDate);
						      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
							
							
							
							try (PreparedStatement psts = connection.prepareStatement(updateProject);) {
								psts.setString(1, newName);
								psts.setString(2, newBuildingName);
								psts.setString(3, newPhysicalAddress);
								psts.setString(4, newERF);
								psts.setDouble(5, newTotalProjectFee);
								psts.setDouble(6, newTotalFeePaidToDate);
								psts.setDate(7, sqlDate);
								psts.setInt(8, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("project updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								e.printStackTrace();
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}

	}
	

	
    /**
     * This function allows the user to change the project details by the project name
     */
	public static void changeContractorsDetailByProjectNameFromListOfObjects() {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				
				try {
					//assign input to project number
					
					System.out.println("Enter project Name ");
					//take user input
					String input = in.nextLine();
					System.out.println("searching your Contractor...\n");
					
					try {
				    
				    String updateContractor = "UPDATE Contractor SET ContractorName = ?, ContractorTelelphoneNumber = ?, ContractorEmailAddress = ?, contractorPyhsicalAddress = ? WHERE Projectid = ?";
					String getContractor = "Select ContractorName,ContractorTelelphoneNumber,ContractorEmailAddress,contractorPyhsicalAddress, Project.Projectid From Contractor  INNER JOIN Project on Project.Projectid = Contractor.Projectid where Project.ProjectName= ?;";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getContractor);
					pst.setString(1, input);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("ContractorName");
							String currentTelephoneNumber = rs.getString("ContractorTelelphoneNumber");
							String currentEmailAddress = rs.getString("ContractorEmailAddress");
							String currentPhysicalAddress = rs.getString("ContractorPyhsicalAddress");
							project_number = rs.getInt("Projectid");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							
							try (PreparedStatement psts = connection.prepareStatement(updateContractor);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
		
	

	}
	
	

    /**
     * This function allows the user to change the architect details by the project name
     */
	public static void changeArchitectDetailByProjectNameFromListOfObjects() {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				
				try {
					//assign input to project number
					
					System.out.println("Enter project Name ");
					//take user input
					String input = in.nextLine();
					System.out.println("searching your Architect...\n");
					
					try {
				    
				    String updateArchitect = "UPDATE Architect SET ArchitectName = ?, ArchitectTelelphoneNumber = ?, ArchitectEmailAddress = ?, ArchitectPyhsicalAddress = ? WHERE Projectid = ?";
					String getArchitect = "Select ArchitectName,ArchitectTelelphoneNumber,ArchitectEmailAddress,ArchitectPyhsicalAddress, Project.Projectid From Architect  INNER JOIN Project on Project.Projectid = Architect.Projectid where Project.ProjectName= ?;";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getArchitect);
					pst.setString(1, input);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("ArchitectName");
							String currentTelephoneNumber = rs.getString("ArchitectTelelphoneNumber");
							String currentEmailAddress = rs.getString("ArchitectEmailAddress");
							String currentPhysicalAddress = rs.getString("ArchitectPyhsicalAddress");
							project_number = rs.getInt("Projectid");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							
							try (PreparedStatement psts = connection.prepareStatement(updateArchitect);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}
	}
	
	

    /**
     * This function allows the user to change the customer details by the project name
     */
	public static void changeCustomerDetailByProjectNameFromListOfObjects()  {
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newTelephoneNumber = "";
		String newEmailAddress = "";
		String newPhysicalAddress = "";
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				
				try {
					//assign input to project number
					
					System.out.println("Enter project Name ");
					//take user input
					String input = in.nextLine();
					System.out.println("searching your Customer...\n");
					
					try {
				    
				    String updateCustomer = "UPDATE Customer SET CustomerName = ?, CustomerTelelphoneNumber = ?, CustomerEmailAddress = ?, CustomerPyhsicalAddress = ? WHERE Projectid = ?";
					String getCustomer = "Select CustomerName,CustomerTelelphoneNumber,CustomerEmailAddress,CustomerPyhsicalAddress, Project.Projectid From Customer  INNER JOIN Project on Project.Projectid = Customer.Projectid where Project.ProjectName= ?;";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getCustomer);
					pst.setString(1, input);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("CustomerName");
							String currentTelephoneNumber = rs.getString("CustomerTelelphoneNumber");
							String currentEmailAddress = rs.getString("CustomerEmailAddress");
							String currentPhysicalAddress = rs.getString("CustomerPyhsicalAddress");
							project_number = rs.getInt("Projectid");
							System.out.println("current name " + currentName);
							System.out.println("current Telephone " + currentTelephoneNumber);
							System.out.println("current Email " + currentEmailAddress);
							System.out.println("current Address " + currentPhysicalAddress);
							
							
							System.out.println("Enter new name");
							newName = in.nextLine();
							System.out.println("Enter new number");
							newTelephoneNumber = in.nextLine();
							System.out.println("Enter new email address");
							newEmailAddress = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
						
							
							try (PreparedStatement psts = connection.prepareStatement(updateCustomer);) {
								psts.setString(1, newName);
								psts.setString(2, newTelephoneNumber);
								psts.setString(3, newEmailAddress);
								psts.setString(4, newPhysicalAddress);
								psts.setInt(5, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("customer updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}

	}
	
	
	
	
	
	/**
	 * The following function allows the user to finalise a project by using the project name

	 */
	public static void FinaliseProjectByProjectName() {
		Scanner in = new Scanner(System.in); //scanner for input
		boolean inputValid = false; 
		double totalProjectFee = 0d; //total project fee
		double totalAmountPaidToDate = 0d; // total amount due
		double balance = 0d; //total porject balance
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  //new simple date formatter 
		Date dateCompleted = new Date();  // date completed i.e. date user finalises the project
		String projectName = "";//for project name
		String customerName ="";
		String customerEmailAddress ="";
		String customerTelephoneNumber ="";
		String customerPhysicalAddress = "";
			inputValid = false;
			//start while loop
			while (!inputValid) {
				System.out.println("Enter project Name ");
				//take user input
				String input = in.nextLine();
				
				try {
					//assign input to project number
					projectName = input;
					
					 try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
									"kushal", "kushal");
							// Create a direct line to the database for running our queries
							Statement statement = connection.createStatement();
							//create a result set
							ResultSet results;
							//SQL Statement to get project still due
							String getProjectByProjectName = "Select ProjectName, Project.Projectid,TotalProjectFee,TotalFeePaidToDate,CustomerName,CustomerTelelphoneNumber,CustomerEmailAddress,CustomerPyhsicalAddress\r\n" + 
									"From Project \r\n" + 
									"INNER JOIN Customer on Project.Projectid = Customer.Projectid\r\n" + 
									"where Project.ProjectName= ?";
							String insertCompleted = "Insert into completed(ProjectName, CustomerName, customerTelephoneNumber, CustomerEmailAddress, customerPhysicalAddress) VALUES (?, ?, ?, ?, ?)";
							PreparedStatement pst = connection.prepareStatement(getProjectByProjectName);
							pst.setString(1, projectName);
							ResultSet rs = pst.executeQuery();
							//if no results
							if (rs.next() == false) {
								System.out.println("Invalid choice try again");
							}
							//display the title searched for
							else {
								do {
									//get total due
									totalProjectFee =rs.getDouble("TotalProjectFee");
									totalAmountPaidToDate =rs.getDouble("TotalFeePaidToDate");
									projectName= rs.getString("ProjectName");
									customerName = rs.getString("CustomerName");
									customerEmailAddress = rs.getString("CustomerEmailAddress");
									customerPhysicalAddress = rs.getString("CustomerPyhsicalAddress");
									customerTelephoneNumber = rs.getString("CustomerTelelphoneNumber");
									int project_number = rs.getInt("Projectid");
									balance = totalProjectFee - totalAmountPaidToDate; // calculate the balance
									// if the the balance is greater than 0 then print the invice
									if (balance > 0d) { 
										System.out.println("==========INVOICE FOR: "+ projectName +"==========");
										System.out.println("\n");
										System.out.println("Customer Name :" + customerName);
										System.out.println("Customer Email :" + customerEmailAddress);
										System.out.println("Customer Telephone Number :" + customerTelephoneNumber);
										System.out.println("Customer Physical Address :" + customerPhysicalAddress);
										System.out.println("Amount To still be paid R" + balance);
										System.out.println("\n");
										
										//add to finalised table
										try (PreparedStatement pstfinal = connection.prepareStatement(insertCompleted);) {
											pstfinal.setString(1, projectName);
											pstfinal.setString(2, customerName);
											pstfinal.setString(3, customerTelephoneNumber);
											pstfinal.setString(4, customerEmailAddress);
											pstfinal.setString(5, customerPhysicalAddress);
											pstfinal.executeUpdate();
											pstfinal.close();
											System.out.println("project deleted and saved");
										} catch (Exception e) {
											System.out.println("Error saving try again");
											e.printStackTrace();
										}
										//remove finalised project from the list of projects
										String deleteArchitct = "delete from architect where projectid = ?";
										String deleteCustomer = "delete from customer where projectid = ?";
										String deleteContractor = "delete from contractor where projectid = ?";
										String deleteProject = "delete from project where projectid = ?";
										try (PreparedStatement pstdel = connection.prepareStatement(deleteArchitct);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("architect deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteCustomer);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("cusotmer deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteContractor);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("contractor deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteProject);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("project deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}							
										inputValid = true;
										break;
										//remove finalised project from the list of projects
										
										//save the updated project details the file that store the current projects
										
									}
									//if the balance is <= 0 we don't generate an invoice
									else if (balance <= 0d) {
										System.out.println("No Invoice to generate as it has been fully paid");
										//write the detail to the finalised project file including the date completed
										//add to finalised table
										try (PreparedStatement pstfinal = connection.prepareStatement(insertCompleted);) {
											pstfinal.setString(1, projectName);
											pstfinal.setString(2, customerName);
											pstfinal.setString(3, customerTelephoneNumber);
											pstfinal.setString(4, customerEmailAddress);
											pstfinal.setString(5, customerPhysicalAddress);
											pstfinal.executeUpdate();
											pstfinal.close();
											System.out.println("project deleted and saved");
										} catch (Exception e) {
											System.out.println("Error saving try again");
											e.printStackTrace();
										}
										//remove finalised project from the list of projects
										String deleteArchitct = "delete from architect where projectid = ?";
										String deleteCustomer = "delete from customer where projectid = ?";
										String deleteContractor = "delete from contractor where projectid = ?";
										String deleteProject = "delete from project where projectid = ?";
										try (PreparedStatement pstdel = connection.prepareStatement(deleteArchitct);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("architect deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteCustomer);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("cusotmer deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteContractor);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("contractor deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}
										try (PreparedStatement pstdel = connection.prepareStatement(deleteProject);) {
											pstdel.setInt(1, project_number);
											pstdel.executeUpdate();
											pst.close();
											System.out.println("project deleted");
										} catch (Exception e) {
											System.out.println("Error updating try again");
										}	
										//remove finalised project from the list of projects
										inputValid = true;
										//save the updated project details the file that store the current projects
										break;
									}
									
									break;
									
									
									
									
								} while (rs.next());
							}
							rs.close();
						}
						catch (SQLException e) {
							// We only want to catch a SQLException - anything else is off-limits for now.
							e.printStackTrace();
						}
			
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid project name");
				}
				

			}

	}
	
	
	
	
	/**
	 * Function to change the project details by the the project name
	 * @throws ParseException
	 */
	public static void changeProjectDetailByProjectNameFromListOfObjects() throws ParseException{
		Scanner in = new Scanner(System.in);
		int project_number = 0;
		boolean inputValid = false;
		String newName = "";
		String newBuildingName = "";
		String newPhysicalAddress = "";
		String newERF = "";
		String userDate = "";
		double newTotalProjectFee = 0d;
		double newTotalFeePaidToDate = 0d;
		
			inputValid = false;
			//start while loop
			while (!inputValid) {
				
				try {
	//assign input to project number
					
					System.out.println("Enter project Name ");
					//take user input
					String input = in.nextLine();
					System.out.println("searching your Project...\n");
					
					try {
				    
				    String updateProject = "UPDATE Project SET ProjectName = ?, BuildingName = ?, PhysicalAddress = ?, ERF = ?, TotalProjectFee =?, TotalFeePaidToDate = ?, UserDate = ? WHERE Projectid = ?";
					String getProject = "SELECT *  FROM Project where ProjectName = ?";
				    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
							"kushal", "kushal");
					// Create a direct line to the database for running our queries
					Statement statement = connection.createStatement();
					//create a result set
					ResultSet results;
					
					PreparedStatement pst = connection.prepareStatement(getProject);
					pst.setString(1, input);
					// process the results
					ResultSet rs = pst.executeQuery();
					//if no results
					if (rs.next() == false) {
						System.out.println("No results");
					}
					//display the title searched for
					else {
						do {
							String currentName = rs.getString("ProjectName");
							String currentBuldingName = rs.getString("BuildingName");
							String currentAddress = rs.getString("PhysicalAddress");
							String currentERF = rs.getString("ERF");
							Double currentTotalProjectFee = rs.getDouble("TotalProjectFee");
							Double currentTotalFeePaidToDate = rs.getDouble("TotalFeePaidToDate");
							project_number = rs.getInt("Projectid");
							Date currentDate = rs.getDate("UserDate");
							
							System.out.println("current name " + currentName);
							System.out.println("current Bulding Name " + currentBuldingName);
							System.out.println("current Address " + currentAddress);
							System.out.println("current ERF " + currentERF);
							System.out.println("current TotalProject Fee " + currentTotalProjectFee);
							System.out.println("current Total Fee Paid To Date " + currentTotalFeePaidToDate);
							System.out.println("current Due date" + currentDate);
							
							
							System.out.println("Enter new project name");
							newName = in.nextLine();
							System.out.println("Enter new building name");
							newBuildingName = in.nextLine();
							System.out.println("Enter new Address");
							newPhysicalAddress = in.nextLine();
							System.out.println("Enter new ERF");
							newERF = in.nextLine();
							newTotalProjectFee = Methods.createProjectFee(in, newTotalProjectFee, "Total fee paid so far e.g. 300.50");
							newTotalFeePaidToDate = Methods.createProjectFee(in, newTotalFeePaidToDate, "Total fee paid so far e.g. 300.50");
							userDate = Methods.createProjectDueDate(in);
						
							
							 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							  java.util.Date utilDate = format.parse(userDate);
						      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
							
							
							
							try (PreparedStatement psts = connection.prepareStatement(updateProject);) {
								psts.setString(1, newName);
								psts.setString(2, newBuildingName);
								psts.setString(3, newPhysicalAddress);
								psts.setString(4, newERF);
								psts.setDouble(5, newTotalProjectFee);
								psts.setDouble(6, newTotalFeePaidToDate);
								psts.setDate(7, sqlDate);
								psts.setInt(8, project_number);
								psts.executeUpdate();
								psts.close();
								System.out.println("project updated");
								inputValid=true;
							} catch (Exception e) {
								System.out.println("Error updating try again");
								e.printStackTrace();
								
							}
							
						} while (rs.next());
					}
					rs.close();
					
					}catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				
					//END: VALID
				} catch (NumberFormatException e) {
					System.out.println("You didn't enter a valid number");
				}
			}

	}
	
	

	
	/*
	 * Function to create a project due date
	 * @param in
	 */
	public static String createProjectDueDate(Scanner in) {
		boolean inputValid; // boolean for inputValid
		inputValid = false; // set to false
		String userDate = ""; // set user date
		//while not inputValid
		while (!inputValid) {
			//create Simple date format with dd/MM/yyyy
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//setLenient handle when the user enters incorrect details
			sdf.setLenient(false);
			System.out.println("Please enter a date e.g (23/05/1993)");
			//take user date from input
			userDate = in.nextLine();
			
			try {
				sdf.parse(userDate); //parse the userDate variable
				System.out.println(userDate + " is a valid Date");
				return userDate;
				//catch when date is invalid
			} catch (Exception e) {
				System.out.println(userDate + " is not a valid Date");
				inputValid = false;
			}
		}
		return userDate;
	}
	

}
	
