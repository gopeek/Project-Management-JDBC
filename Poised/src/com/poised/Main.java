package com.poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * Where main program will run
 * @author Kushal Gopee
 * @version 1.0
 *
 */
public class Main {

	/**
	 * Function to prompt user questions that require answers. This will only be for String inputs
	 * @param buf buffer reader for taking in user input
	 * @param message Message the user wants to display
	 * @return return Return the user choice
	 * @throws IOException
	 */
	private static String promptUser(BufferedReader buf, String message) throws IOException {
		System.out.println(message); // prompt message to user
		String userChoice = buf.readLine(); // read users choice
		if (userChoice.length() == 0) {
			userChoice = "NULL";
			return userChoice;
		}
		else {
		return userChoice; // return user choice
		}
	}
	
	/**
	 * Function to display the main menu option to the user
	 * @param in Scanner to take user input
	 * @param userOption This is for the user option i.e. the menu option of the user.
	 * @param userMessage This is for the user option i.e. the menu option of the user.
	 * @return userOption Return the user choice
	 */
	private static int mainMenuUserOption(Scanner in, int userOption, String userMessage) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			// display message to user
			System.out.println(userMessage);
			// take the user input
			String input = in.nextLine();

			try {
				// assign user input to userOption [cast to integer]
				userOption = Integer.parseInt(input);
				
				// if user option >= 1 or <=6 because there are 4 menu options
				if ((userOption >= 1 || userOption <=6)) {
					// return the user option
					return userOption;
				}
				// if user option == 1 because there are 1 menu options
				// This menu option is only available because no projects have been selected.
				else if (userOption == 1) {
					// return the user option
					return userOption;
				}

				// invalid user option
				else {
					System.out.println("Incorrect user option");
					inputValid = false;
				}
			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		// return
		return userOption;
	}
	
	/**
	 * Function to take in the user option in order to determine which aspect of the project the user wishes to update
	 * @param in
	 * @param userOption
	 * @param userMessage
	 * @return userOption Return the user choice
	 */
	private static int updateUserDetailsMenuOfListOfProjects(Scanner in, int userOption, String userMessage) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			// display message to user
			System.out.println(userMessage);
			// take the user input
			String input = in.nextLine();

			try {
				// assign user input to userOption [cast to integer]
				userOption = Integer.parseInt(input);
				// if user option >= 1 or <=4 because there are 4 menu options
				if (userOption >= 1 || userOption <= 4) {
					// return the user option
					return userOption;
				}

				// invalid user option
				else {
					System.out.println("Incorrect user option");
					inputValid = false;
				}
			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		// return
		return userOption;
	}

	/*
	 * Function for sub Menu Option. It will display the sub menu option. It will
	 * take a message so you can customize the sub menu to the user.
	 * 
	 * @param in
	 * @param userOption
	 * @param menuMessage
	 */
	private static int subMenuOption(Scanner in, int userOption, String menuMessage) {
		boolean inputValid; // start valid input boolean
		inputValid = false; // set it to false
		// while not false
		while (!inputValid) {
			System.out.println(menuMessage); // prompt message to user
			String input = in.nextLine(); // read user Input

			try {
				userOption = Integer.parseInt(input); // assign input to userOption
				// if user option >= 1 or <=2 because there are 2 menu options
				if (userOption >= 1 || userOption <= 2) {
					return userOption;
				}
				// if userOption falls out of 1 and 2
				else {
					System.out.println("Enter a valid user option");
					inputValid = false; // start loop again
				}

			}
			// catch if user enter anything that is not a number
			catch (NumberFormatException e) {
				// tell the user they did not eneter a valid number
				System.out.println("You didn't enter a valid number");
			}
		}
		return userOption;
	}
	

    
    

    /**
     * Main function where entire project will run
     * @param args
     * @throws ParseException
     * @throws IOException
     */
	public static void main(String[] args) throws ParseException, IOException {

		/**
		 * @param myFormat creates a simpldate format for user to eneter date e.g. 23/05/2020
		 */
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		/**
		 * create buffer reader to read user
		 */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * Scanner for input
		 */
		Scanner in = new Scanner(System.in); 
		/**
		 * variable for total fee for project 
		 * variable for total fee paid to date
		 */
		double totalFeeForProject = 0;
		double totalFeePaidToDate = 0; 
		/**
		 * 	user date
		 * 	get the current Date
		 */
		String userDate = "";
		Date currentDate = new Date();
		/**
		 * the sub user option variable i.e. 1 or 2 [1 for project number and 2 for project name]
		 */
		int sub_user_option = 0; 
	
		boolean isTrueMainMenu = true; 
		
		//while loop to start the menu
		while(isTrueMainMenu == true) {
			
		
		
		
			
			//start counter for project list of objects
			int counterForProjectListOfObjects=0;
			System.out.println("===========Welcome to Poised===========");
			System.out.println("Here is a list of projects");

			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
						"kushal", "kushal");
				// Create a direct line to the database for running our queries
				Statement statement = connection.createStatement();
				//create a result set
				ResultSet results;
				
				results = statement.executeQuery("Select Projectid, ProjectName from Project");
				//print results 
				while (results.next()) {
					System.out.println("project Number and Name: " + results.getInt("Projectid") + ", " + results.getString("ProjectName"));
				}
				System.out.println("\n");
			}
			catch (SQLException e) {
				// We only want to catch a SQLException - anything else is off-limits for now.
				e.printStackTrace();
			}
			//take in main menu first user option
			int takeInFirstUserOption = 0;
			// take in the users for which detail of the project they wish to update
			int updateDetailsUserOption =0;
			
			
			 takeInFirstUserOption = mainMenuUserOption(in, takeInFirstUserOption,"Would you like to \n"
					+ "[1] Add a project to this list \n"
					+ "[2] See list of projects that still need to be completed \n"
					+ "[3] See list of projects that are past the due date \n"
					+ "[4] Update project details \n"
					+ "[5] Finalise project \n"
					+ "[6] Exit Program"
					);
			
			//if the user wants to add a project
			 if (takeInFirstUserOption == 1) {
					
				
						/* PROJECT DETAILS: BEGIN */
						String projectName = promptUser(buf, "enter the project name ");
						String buildingName = promptUser(buf, "What type of building is being designed");
						String physicalAddress = promptUser(buf, "What is the physical address for the project");
						String ERF = promptUser(buf, "What is the ERF number?");
						

						totalFeeForProject = Methods.createProjectFee(in, totalFeeForProject,
								"Total fee for the project e.g. 300.50");

						totalFeePaidToDate = Methods.createProjectFee(in, totalFeePaidToDate, "Total fee paid so far e.g. 300.50");

						userDate = Methods.createProjectDueDate(in);
						/* PROJECT DETAILS: END */

						/* CONTRACTOR DETAILS: BEGIN */
						String contractorName = promptUser(buf, "Enter the contractors Name");
						String contractorTelephoneNumber = promptUser(buf,
								"Enter the cotractors telephone number e.g. (012) 807-6778");
						String contractorEmailAddress = promptUser(buf,
								"Enter the cotractors email address e.g. example@gmail.com");
						String contractorPyhsicalAddress = promptUser(buf, "Enter the cotractors physical address");
						/* CONTRACTOR DETAILS: END */

						/* ARCHITECT DETAILS: BEGIN */
						String architectName = promptUser(buf, "Enter the architects Name");
						String architectTelephoneNumber = promptUser(buf,
								"Enter the architect telephone number e.g. (012) 807-6778");
						String architectEmailAddress = promptUser(buf, "Enter the architect email address e.g. example@gmail.com");
						String architectPyhsicalAddress = promptUser(buf, "Enter the architect physical address");
						/* ARCHITECT DETAILS: END */

						/* CUSTOMER DETAILS: BEGIN */
						String customerName = promptUser(buf, "Enter the customers Name");
						String customerTelephoneNumber = promptUser(buf,
								"Enter the customers telephone number e.g. (012) 807-6778");
						String customerEmailAddress = promptUser(buf, "Enter the customers email address e.g. example@gmail.com");
						String customerPyhsicalAddress = promptUser(buf, "Enter the customers physical address");
						/* CUSTOMER DETAILS: END */

						// if the project name is empty
						if (projectName.isEmpty()) {
							projectName = buildingName + " " + customerName;
						}
					
						
						/*BEGIN: INSERT DATA*/
						try {
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
									"kushal", "kushal");
							// Create a direct line to the database for running our queries
							Statement statement = connection.createStatement();
							//create a result set
							ResultSet res;
							String insertProjectName = "Insert into Project(ProjectName,BuildingName,PhysicalAddress,ERF,TotalProjectFee,TotalFeePaidToDate,UserDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
							String insertProjectContractor = "Insert into Contractor(ContractorName,ContractorTelelphoneNumber,ContractorEmailAddress,contractorPyhsicalAddress,Projectid) VALUES (?, ?, ?, ?, ?)";
							String insertProjectArchitect =  "Insert into Architect(ArchitectName,ArchitectTelelphoneNumber,ArchitectEmailAddress,ArchitectPyhsicalAddress,Projectid) VALUES (?, ?, ?, ?, ?)";
							String insertProjectCustomer = "Insert into Customer(CustomerName,CustomerTelelphoneNumber,CustomerEmailAddress,CustomerPyhsicalAddress,Projectid) VALUES (?, ?, ?, ?, ?)";
							  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							  java.util.Date utilDate = format.parse(userDate);
						        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
						
							// Add a record to project:
							try (PreparedStatement pst = connection.prepareStatement(insertProjectName);) {
								pst.setString(1, projectName);
								pst.setString(2, buildingName);
								pst.setString(3, physicalAddress);
								pst.setString(4, ERF);
								pst.setDouble(5, totalFeeForProject);
								pst.setDouble(6, totalFeePaidToDate);
								pst.setDate(7, sqlDate);
								pst.executeUpdate();
								pst.close();
								System.out.println("project name saved");
							} catch (Exception e) {
								System.out.println("Error saving try again");
							}
							
							//get latest id
							res = statement.executeQuery("select max(Projectid) from Project");
							res.next();
							int latestId = res.getInt("max(Projectid)");
							System.out.println(latestId);
							
							// Add a record to contractor:
							try (PreparedStatement pst = connection.prepareStatement(insertProjectContractor);) {
								pst.setString(1, contractorName);
								pst.setString(2, contractorTelephoneNumber);
								pst.setString(3, contractorEmailAddress);
								pst.setString(4, contractorPyhsicalAddress);
								pst.setInt(5, latestId);
								pst.executeUpdate();
								pst.close();
								System.out.println("contractor saved");
							} catch (Exception e) {
								System.out.println("Error saving try again");
							}
						
							// Add a record to Architect:
							try (PreparedStatement pst = connection.prepareStatement(insertProjectArchitect);) {
								pst.setString(1, architectName);
								pst.setString(2, architectTelephoneNumber);
								pst.setString(3, architectEmailAddress);
								pst.setString(4, architectPyhsicalAddress);
								pst.setInt(5, latestId);
								pst.executeUpdate();
								pst.close();
								System.out.println("contractor saved");
							} catch (Exception e) {
								System.out.println("Error saving try again");
							}
							
							// Add a record to Architect:
							try (PreparedStatement pst = connection.prepareStatement(insertProjectCustomer);) {
								pst.setString(1, customerName);
								pst.setString(2, customerTelephoneNumber);
								pst.setString(3, customerEmailAddress);
								pst.setString(4, customerPyhsicalAddress);
								pst.setInt(5, latestId);
								pst.executeUpdate();
								pst.close();
								System.out.println("Architect saved");
							} catch (Exception e) {
								System.out.println("Error saving try again");
							}
						
						

						
						}
						catch (SQLException e) {
							// We only want to catch a SQLException - anything else is off-limits for now.
							e.printStackTrace();
						}
						
						
						
						/*END: INSERT DATA*/
						
					isTrueMainMenu = true;
			 
 
			 }
			 //See list of projects that still need to be completed
			 else if (takeInFirstUserOption == 2) {
			     System.out.println("\nHere is a list projects that still need to be completed"); 
			
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
								"kushal", "kushal");
						// Create a direct line to the database for running our queries
						Statement statement = connection.createStatement();
						//create a result set
						ResultSet results;
						//SQL Statement to get project still due
						String projectStillToComplete = " SELECT * FROM project WHERE UserDate >= CURDATE()";
						results = statement.executeQuery(projectStillToComplete);
						while (results.next()) {
							System.out.println("project Number and Name and Date: " + results.getInt("Projectid") + ", " + results.getString("ProjectName") + ", " + results.getString("UserDate"));
						}
						System.out.println("\n");
					}
					catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				 //exit from the menu option
				 isTrueMainMenu = true;
				 
			 }
			 
			 //See list of projects that are past the due date
			 else if (takeInFirstUserOption == 3) {
				 
				 System.out.println("\nHere is a list projects that are past the due date"); 
				 try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisepms?useSSL=false&allowPublicKeyRetrieval=true",
								"kushal", "kushal");
						// Create a direct line to the database for running our queries
						Statement statement = connection.createStatement();
						//create a result set
						ResultSet results;
						//SQL Statement to get project still due
						String projectStillToComplete = " SELECT * FROM project WHERE UserDate <= CURDATE()";
						results = statement.executeQuery(projectStillToComplete);
						while (results.next()) {
							System.out.println("project Number and Name and Date: " + results.getInt("Projectid") + ", " + results.getString("ProjectName") + ", " + results.getString("UserDate"));
						}
						System.out.println("\n");
					}
					catch (SQLException e) {
						// We only want to catch a SQLException - anything else is off-limits for now.
						e.printStackTrace();
					}
				 //exit from the menu option
				 isTrueMainMenu = true;
			 }
			 //if user wants to Update project details aspects
			 else if (takeInFirstUserOption == 4) {
				 //take user option for which aspect of the project they wish to update
				 updateDetailsUserOption=updateUserDetailsMenuOfListOfProjects(in, takeInFirstUserOption,"What would you like to update \n"
					 		+ "[1] Project \n"
					 		+ "[2] Contractor \n"
					 		+ "[3] Architect \n"
					 		+ "[4] Customer  \n");
				 
				 //BEGIN: if user wants to update projects
				 if (updateDetailsUserOption == 1) {
						sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeProjectDetailByProjectNumberFromListOfObjects();
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeProjectDetailByProjectNameFromListOfObjects();
						}
				 }
				 //END: if user wants to update projects
				 
				 //BEGIN: if user wants to Contractor details
				 else if (updateDetailsUserOption ==2){
						sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeContractorsDetailByProjectNumberFromListOfObjects();
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeContractorsDetailByProjectNameFromListOfObjects();
						}
				 	}
				 //END: if user wants to Contractor details
				 
				 //BEGIN: if user wants to Architect details
				 else if (updateDetailsUserOption == 3) {
					 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
					//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeArchitectDetailByProjectNumberFromListOfObjects();
						}
					//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeArchitectDetailByProjectNameFromListOfObjects();
						}
				 }
				//END: if user wants to Architect details
				 
				 //BEGIN: if user wants to update Customer details
				 else if (updateDetailsUserOption == 4) {
					 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
								+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
						//if user want to search by project number
						if (sub_user_option == 1) {
							Methods.changeCustomerDetailByProjectNumberFromListOfObjects();
						}
						//if user want to search by project name
						else if (sub_user_option == 2) {
							Methods.changeCustomerDetailByProjectNameFromListOfObjects();
						}
				 }
				 //END: if user wants to update Customer details
			 }
			 
			 //if user wants to Update project details aspects
			 else if (takeInFirstUserOption == 5) {
				 sub_user_option = subMenuOption(in, sub_user_option, "Would you like to search by: \n"
							+ "option [1] project number\n" + "option [2] project name\n" + "Enter option");
				//if user want to search by project number
					if (sub_user_option == 1) {
						Methods.FinaliseProjectByProjectNumber();
					}
				//if user want to search by project name
					else if (sub_user_option == 2) {
						Methods.FinaliseProjectByProjectName();
					}
			 }
			 
			 //if user wants to exit the project
			 else if (takeInFirstUserOption == 6) {
				 System.out.println("Details saved");
				 System.out.println("Program exiting");
				 System.exit(0);
			 }
			
			
		}
		
	}

}
