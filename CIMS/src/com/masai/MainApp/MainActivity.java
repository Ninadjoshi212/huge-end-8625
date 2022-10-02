package com.masai.MainApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.AdminUseCase.DetailedListOfAllFIR;
import com.masai.AdminUseCase.FirByStationName;
import com.masai.AdminUseCase.OfficerStationMap;
import com.masai.AdminUseCase.RegisterOfficer;
import com.masai.AdminUseCase.RegisterPolice_Station;
import com.masai.OfficerUseCases.Update;
import com.masai.AdminUseCase.CheckStatus;
import com.masai.AdminUseCase.CountSolvedFIR;
import com.masai.OfficerUseCases.SolvedCasesRecord;
import com.masai.AdminUseCase.CountUnsolvedFIR;
import com.masai.AdminUseCase.CriminalsByStationName;
import com.masai.AdminUseCase.CurrentMonthFIRRecord;
import com.masai.OfficerUseCases.UnsolvedCasesRecord;
import com.masai.OfficerUseCases.AllCriminalsRecord;
import com.masai.OfficerUseCases.AllFIRRecord;
import com.masai.OfficerUseCases.CrimeCriminalMap;
import com.masai.OfficerUseCases.CriminalById;
import com.masai.OfficerUseCases.CriminalByName;
import com.masai.OfficerUseCases.DeleteCrimeMappedToCriminal;
import com.masai.OfficerUseCases.DeleteCrimeNotMappedToCriminal;
import com.masai.OfficerUseCases.DeleteCriminalMappedToCrime;
import com.masai.OfficerUseCases.DeleteCriminalNotMappedToCrime;
import com.masai.OfficerUseCases.FIRByCrimeType;
import com.masai.OfficerUseCases.FIRById;
import com.masai.OfficerUseCases.RegisterCriminal;
import com.masai.OfficerUseCases.RegisterFIR;
import com.masai.utility.DBUtil;

public class MainActivity {

	public static void user_Logout() {

		System.out.println("Thank You....!");
		System.exit(0);
	}

	public static int checkCridentials(int officer_Id, String username, String password) {

		int rk = 0;

		try (Connection con = DBUtil.getconnection()) {

			if (con != null)
				System.out.println("*** Welcome to Crime Management System Application ***");
				System.out.println();

			PreparedStatement ps = con.prepareStatement(
					"select * from Officers where officer_Id=? And officer_username=? And officer_password=? ");
			ps.setInt(1, officer_Id);
			ps.setString(2, username);
			ps.setString(3, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String nm = rs.getString("officer_name");
				String unm = rs.getString("officer_username");
				String upass = rs.getString("officer_password");
				String rank = rs.getString("officer_rank");

				System.out.println("Welcome " + rank + " " + nm);
				System.out.println();

				if (rank.equals("Commissioner")) {

					rk = 1;

				} else {

					rk = 2;

				}

			} else
				System.out.println("Record does not exist..");

		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}

		return rk;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("*** LOGIN ***");

		System.out.println("Enter UserId");
		int id = sc.nextInt();

		System.out.println("Enter UserName");
		String username = sc.next();

		System.out.println("Enter Password");
		String password = sc.next();

		int rank = MainActivity.checkCridentials(id, username, password);

		if (rank == 1) {

			try {

				while (true) {

					System.out.println("*** MENU ***");

					System.out.println(
							  "1. Add PoliceStation \n"
							+ "2. Add Officers \n"
							+ "3. Allot Officer To Station \n"
							+ "4. Fetch Criminals By Station Area \n"
							+ "5. Fetch FIR By Station Area \n"
							+ "6. Fetch Detailed List Of FIR \n"
							+ "7. Count Number Of FIR Filed in Current Month \n"
							+ "8. Count Number Of Solved FIR \n"
							+ "9. Count Number Of Unsolved FIR \n"
							+ "10. Fetch Details Of Solved FIR \n"
							+ "11. Fetch Details Of Unsolved FIR \n"
							+ "12. Check Status Of FIR \n"
							+ "13. Logout");

					System.out.println("\nPlease select an Option to continue...");

					int option = sc.nextInt();

					switch (option) {

					case 1:
						RegisterPolice_Station.main(args);
						break;

					case 2:
						RegisterOfficer.main(args);
						break;

					case 3:
						OfficerStationMap.main(args);
						break;

					case 4:
						CriminalsByStationName.main(args);
						break;
						
					case 5:
						FirByStationName.main(args);
						break;

					case 6:
						DetailedListOfAllFIR.main(args);
						break;
					
					case 7:
						CurrentMonthFIRRecord.main(args);
						break;
					
					case 8:
						CountSolvedFIR.main(args);
						break;
						
					case 9:
						CountUnsolvedFIR.main(args);
						break;

					case 10:
						SolvedCasesRecord.main(args);
						break;
						
					case 11:
						UnsolvedCasesRecord.main(args);
						break;

					case 12:
						CheckStatus.main(args);
						break;

					case 13:
						MainActivity.user_Logout();
						break;

					}

				}

			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Wrong Choice");
			}

		}
        else if (rank == 2) {

        	try {

				while (true) {

					System.out.println();
					System.out.println("*** MENU ***");
					System.out.println("==============");
					System.out.println();

					System.out.println(
							"CRIME SECTION \n"
							+ "1. Add FIR \n"
							+ "2. Fetch All FIR Record \n"
							+ "3. Map Criminal To Crime \n"
							+ "4. Delete FIR Not Mapped To Criminal \n"
							+ "5. Delete FIR Mapped To Criminal \n"
							+ "6. Search FIR By ID \n"
							+ "7. Search FIR By Crime Type \n"
							+ "CRIMINAL SECTION \n"
							+ "8. Add Criminal \n"
							+ "9. Fetch All Criminals Record \n"
							+ "10. Delete Criminal Mapped To FIR \n"
							+ "11. Delete Criminal Not Mapped To FIR \n"
							+ "12. Search Criminal By ID \n"
							+ "13. Search Criminal By Name \n"
							+ "RECORDS SECTION \n"
							+ "14. Solved FIR Records \n"
							+ "15. UnSolved FIR Records \n"
							+ "16. Update FIR Status \n"
							+ "17. LogOut");

					System.out.println("\nPlease select an Option to continue...");

					int option = sc.nextInt();

					switch (option) {
					
					case 1:
						RegisterFIR.main(args);
						break;

					case 2:
						AllFIRRecord.main(args);
						break;

					case 3:
						CrimeCriminalMap.main(args);
						break;

					case 4:
						DeleteCrimeNotMappedToCriminal.main(args);
						break;

					case 5:
						DeleteCrimeMappedToCriminal.main(args);
						break;

					case 6:
						FIRById.main(args);
						break;

					case 7:
						FIRByCrimeType.main(args);
						break;
					
					case 8:
						RegisterCriminal.main(args);
						break;
					
					case 9:
						AllCriminalsRecord.main(args);
						break;
					
					case 10:
						DeleteCriminalMappedToCrime.main(args);
						break;
					
					case 11:
						DeleteCriminalNotMappedToCrime.main(args);
						break;
					
					case 12:
						CriminalById.main(args);
						break;
					
					case 13:
						CriminalByName.main(args);
						break;
						
					case 14:
						SolvedCasesRecord.main(args);
						break;
					
					case 15:
						UnsolvedCasesRecord.main(args);
						break;
					
					case 16:
						Update.main(args);
						break;
					
					case 17:
						MainActivity.user_Logout();
						break;

					}

				}

			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("Invalid Choice");
			}

        } else {

        	System.out.println("Invalid UserName or Password ! Please Try Again...");

	}
	}

}
