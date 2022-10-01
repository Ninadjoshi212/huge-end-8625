package com.masai.AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Crime;
import com.masai.Bean.PoliceOfficer;
import com.masai.Bean.Police_Station;
import com.masai.Bean.StationCriminal;
import com.masai.Exceptions.CrimeException;
import com.masai.Exceptions.OfficerException;
import com.masai.Exceptions.Police_StationException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

//############################# Register PoliceStation #############################
	@Override
	public String registerPoliceStation(Police_Station police) {
		
		// TODO Auto-generated method stub

		String message = "Not Inserted..";

		try(Connection conn = DBUtil.getconnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into Police_Station(PoliceStation_Name, PoliceStation_Area) values(?,?)");

			ps.setString(1, police.getPoliceStation_Name());

			ps.setString(2, police.getPoliceStation_Area());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "PoliceStation Created Successfully...";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

//############################# Register Officer #############################
	@Override
	public String registerOfficers(PoliceOfficer officer) {
		// TODO Auto-generated method stub

		String message = "Not Inserted..";

		try(Connection conn = DBUtil.getconnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"insert into Officers(officer_name, officer_username, officer_password, officer_rank, DateOfJoining) values(?,?,?,?,?)");

			ps.setString(1, officer.getOfficer_Name());

			ps.setString(2, officer.getOfficer_Username());
			
			ps.setString(3, officer.getOfficer_Password());
			
			ps.setString(4, officer.getOfficer_Rank());
			
			ps.setString(5, officer.getDateOfJoining());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Officer Created Successfully...";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;

	}

//############################# Map Officer to PoliceStation #############################
	@Override
	public String registerOfficerToStation(Integer officer_Id, Integer station_Id) throws OfficerException,Police_StationException {
		

		String message = "failed to map officer to station";
		
		try(Connection con = DBUtil.getconnection()) {
			
			PreparedStatement ps1 = con.prepareStatement("select * from Officers where officer_Id = ?");
			ps1.setInt(1, officer_Id);
			
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				
				PreparedStatement ps2 = con.prepareStatement("Select * from Police_Station where station_Id = ?");
				ps2.setInt(1, station_Id);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = con.prepareStatement("insert into officer_station (station_id,officer_id) values(?,?);");
					
					ps3.setInt(2, station_Id);
					ps3.setInt(1, officer_Id);
					
					int insert = ps3.executeUpdate();
					
					if(insert > 0) {
						message = "Officer " + officer_Id +  " is successfully mapped to Station " + station_Id ;
					}
					
				}
				
				else {
					throw new Police_StationException("Invalid officer_id");
				}
				
			}
			
			else {
				
				throw new OfficerException("Invalid station_id");
				
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		return message;
		
	}
	
//############################# Get Criminal By Station Area #############################
	@Override
	public List<StationCriminal> getCriminalsByStationArea(String PoliceStation_Area)
			throws Police_StationException {

		List<StationCriminal> dtos = new ArrayList<>();

		try (Connection conn = DBUtil.getconnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select c.Criminal_Id, c.name, c.address, c.age, c.crime, c.identity_mark, p.PoliceStation_Name, p.PoliceStation_Area from  Criminal c INNER JOIN Police_Station p INNER JOIN criminal_station pc ON c.criminal_Id = pc.criminal_Id AND p.station_Id = pc.station_Id AND p.PoliceStation_Area= ?");

			ps.setString(1, PoliceStation_Area);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("Criminal_Id");
				String na = rs.getString("Criminal_Name");
				String p1 = rs.getString("Criminal_Address");
				String p2 = rs.getString("policeStation_Name");
				String p3 = rs.getString("policeStation_Area");

				StationCriminal dto = new StationCriminal(id, na, p1, p2, p3);

				dtos.add(dto);

			}

		} catch (SQLException e) {
			throw new Police_StationException(e.getMessage());
		}

		if (dtos.isEmpty())
			throw new Police_StationException("No Criminal found in that Police Staion ");

		return dtos;

	}

//############################# Detailed List Of Crime #############################
	@Override
	public void detailedListOfFIR() {

		try (Connection con = DBUtil.getconnection()) {
			PreparedStatement ps = con.prepareStatement(
					"SELECT t.crime_id, t.criminal_id, c.name, c.address, c.crime, c.identity_mark, x.police_station_name, x.victims, x.date, x.detailed_des, x.status FROM crime x INNER JOIN criminal c INNER JOIN crime_by_criminal t ON t.crime_id = x.crime_id and t.criminal_id = c.criminal_id group by t.crime_id ");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println();

				System.out.println("FIR id : " + rs.getInt("t.crime_id"));
				System.out.println("Alloted to police station: "+ rs.getString("police_station_name"));
				System.out.println("Criminal id : " + rs.getInt("criminal_id"));
				System.out.println("Criminal Name : " + rs.getString("name"));
				System.out.println("Criminal Address : " + rs.getString("address"));
				System.out.println("Crime Type : " + rs.getString("crime"));
				System.out.println("Crime id : " + rs.getInt("crime_id"));
				System.out.println("Victims : " + rs.getInt("victims"));
				System.out.println("Crime Date : " + rs.getString("date"));
				System.out.println("Details Of Crime : " + rs.getString("detailed_des"));
				System.out.println("Status of FIR : " + rs.getString("status"));
				System.out.println();

				System.out.println("===========================================================================");

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}	

//############################# Count Of Solved Cases #############################
	@Override
	public String numberOfSolvedFIR() {

		String message = "There is No Solved FIR in entire Database";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("select count(status) from crime where status = ?;");
			ps.setString(1, "solved");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int count = rs.getInt("count(status)");
				message = "Total Number of Solved FIR = " + count;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}

//############################# Count Of Un-Solved Cases #############################
	@Override
	public String numberOfUnsolvedFIR() {

		String message = "No Unsolved cases ";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("select count(status) from crime where status = ?;");
			ps.setString(1, "Unsolved");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int count = rs.getInt("count(status)");
				message = "Total Number of Unsolved FIR = " + count;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}
	
//############################# Count Of FIR Filed in Current Month #############################	
	@Override
	public String countNumberOfFIRInCurrentMonth() {

		String message = "No FIR filed in current month";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement(
					"select count(date) from crime where month(date) = month(current_date) and year(date) = year(current_date);");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int count = rs.getInt("count(date)");
				message = "Total FIR filed in current month = " + count;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}

//############################# Check Status Of FIR #############################	
	public String checkStatusOfFIR(int crime_id) throws CrimeException {

		String message = "Invalid FIR Id";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("select status from crime where crime_id = ?;");
			ps.setInt(1, crime_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				message = "Current Status of FIR " + crime_id + " is " + rs.getString("status");

			} else {

				throw new CrimeException("Invalid FIR ID " + crime_id);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CrimeException(e.getMessage());
		}

		return message;

	}

}
