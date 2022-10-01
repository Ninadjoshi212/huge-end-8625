package com.masai.OfficerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.utility.DBUtil;
import com.masai.Bean.Crime;
import com.masai.Bean.Criminal;
import com.masai.Exceptions.CrimeException;
import com.masai.Exceptions.CriminalException;

public class OfficerDaoImpl implements OfficerDao {

//############################# Map Criminal To Crime #############################
	@Override
	public String registerCriminalToCrime(int crime_id, int criminal_id) throws CriminalException, CrimeException {

		String message = "failed to map criminal to crime";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps1 = con.prepareStatement("select * from crime where crime_id = ?;");
			ps1.setInt(1, crime_id);

			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {

				PreparedStatement ps2 = con.prepareStatement("Select * from criminal where criminal_id = ?;");
				ps2.setInt(1, criminal_id);
				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {

					PreparedStatement ps3 = con
							.prepareStatement("insert into crime_by_criminal (crime_id,criminal_id) values(?,?);");

					ps3.setInt(1, crime_id);
					ps3.setInt(2, criminal_id);

					int insert = ps3.executeUpdate();

					if (insert > 0) {
						message = "Criminal_id " + criminal_id + " is successfully mapped to crime_id " + crime_id;
					}

				}

				else {
					throw new CriminalException("Invalid Criminal_id");
				}

			}

			else {

				throw new CrimeException("Invalid Crime_id");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
	}

//############################# Search Crime By Criminal ID #############################
	@Override
	public void searchCrimeByCriminal(int crime_id, int criminal_id) throws CrimeException, CriminalException {

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps1 = con.prepareStatement("select crime_id from crime_by_criminal where crime_id = ?;");
			ps1.setInt(1, crime_id);

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = con
						.prepareStatement("select criminal_id from crime_by_criminal where criminal_id = ?;");
				ps2.setInt(1, criminal_id);

				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {

					PreparedStatement ps3 = con.prepareStatement(
							"select t.crime_id, t.criminal_id, c.name,c.address, c.crime, x.victims, x.date, x.detailed_des, x.status from crime x inner join criminal c inner join crime_by_criminal t on x.crime_id = ? and c.criminal_id = ? and t.crime_id = ? and t.criminal_id = ?");
					ps3.setInt(1, crime_id);
					ps3.setInt(2, criminal_id);
					ps3.setInt(3, crime_id);
					ps3.setInt(4, criminal_id);

					ResultSet rs3 = ps3.executeQuery();

					if (rs3.next()) {

						System.out.println("Case id : " + rs3.getInt("crime_id"));
						System.out.println("Criminal id : " + rs3.getInt("criminal_id"));
						System.out.println("Name of the Criminal : " + rs3.getString("name"));
						System.out.println("Address of the criminal : " + rs3.getString("address"));
						System.out.println("Name of Crime : " + rs3.getString("crime"));
						System.out.println("Crime_id : " + rs3.getInt("crime_id"));
						System.out.println("Number of Victims : " + rs3.getInt("victims"));
						System.out.println("Date : " + rs3.getString("date"));
						System.out.println("Detailed description of crime : " + rs3.getString("detailed_des"));
						System.out.println("Status of the case : " + rs3.getString("status"));
						System.out.println();

					} else {

						throw new CrimeException(
								"crime id " + crime_id + " is not mapped with criminal_id " + criminal_id);

					}

				} else {
					throw new CriminalException("Invalid criminal_id");
				}
			} else {
				throw new CrimeException("Invalid crime_id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

//############################# delete Crime By Criminal ID #############################
	@Override
	public String deleteCrimeByCriminalId(int crime_id, int criminal_id) throws CriminalException, CrimeException {

		String message = "Failed to Delete FIR ID " + crime_id + " it not mapped with Criminal Id " + criminal_id;

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps1 = con.prepareStatement("select case_id from crime_by_criminal where crime_id = ?;");
			ps1.setInt(1, crime_id);

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				PreparedStatement ps2 = con.prepareStatement(" select * from crime_by_criminal where criminal_id = ?;");
				ps2.setInt(1, criminal_id);

				ResultSet rs2 = ps2.executeQuery();

				if (rs2.next()) {

					PreparedStatement ps3 = con
							.prepareStatement("delete  from crime_by_criminal where crime_id = ? and criminal_id = ?;");
					ps3.setInt(1, crime_id);
					ps3.setInt(2, criminal_id);

					int rs3 = ps3.executeUpdate();

					if (rs3 > 0) {

						message = "case with FIR ID " + crime_id + " Mapped with Criminal Id " + criminal_id
								+ " Removed from Database";

					} else {
						throw new CrimeException(message);
					}

				} else {
					throw new CriminalException("Invalid Criminal Id");
				}
			} else {
				throw new CrimeException("Invalid FIR ID");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return message;

	}

//############################# Register FIR #############################
	@Override
	public String registerFIR(Crime c) {

		String message = "Failed to insert details...";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement(
					"insert into Crime (Name_of_crime, Victims, Detailed_des,Date,Police_station_name,suspected,status) values(?,?,?,?,?,?,?);");

			ps.setString(1, c.getName());
			ps.setInt(2, c.getVictims());
			ps.setString(3, c.getDetails());
			ps.setString(4, c.getDate());
			ps.setString(5, c.getPolice());
			ps.setString(6, c.getSuspected());
			ps.setString(7, c.getStatus());

			int update = ps.executeUpdate();

			if (update > 0) {

				message = "Details Inserted Successfully...";

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
	}

//############################# Get All FIR #############################
	@Override
	public List<Crime> getAllFIR() throws CrimeException {

		List<Crime> list = new ArrayList<>();

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("select * from Crime;");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("Crime_id");
				String name = rs.getString("Name_of_crime");
				Integer victim = rs.getInt("victims");
				String desc = rs.getString("detailed_des");
				String date = rs.getString("date");
				String sno = rs.getString("police_station_name");
				String suspect = rs.getString("Suspected");
				String status = rs.getString("Status");

				Crime c1 = new Crime(id, name, victim, desc, date, sno, suspect, status);
				list.add(c1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CrimeException(e.getMessage());
		}

		if (list.isEmpty()) {

			throw new CrimeException();

		}

		return list;

	}

//############################# delete Crime Not Mapped To Criminal #############################
	@Override
	public String deleteCrimeNotMappedToCriminal(int id) {

		String message = "Invalid FIR ID " + id;

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("delete from crime where crime_id = ?;");
			ps.setInt(1, id);

			int status = ps.executeUpdate();

			if (status > 0) {

				message = "FIR " + id + " Removed from Database...";

				PreparedStatement ps3 = con.prepareStatement("alter table crime auto_increment = ?;");
				ps3.setInt(1, id);

				ps3.executeUpdate();

			}

		} catch (SQLException e) {

			message = e.getMessage();

		}

		return message;

	}

//############################# Delete Crime Mapped To Criminal #############################
	@Override
	public String deleteCrimeMappedToCriminal(int id) throws CrimeException {
		String message = "FIR " + id + " Not Present in Database";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps1 = con.prepareStatement("Delete from crime_by_criminal where crime_id = ?;");

			ps1.setInt(1, id);

			int status = ps1.executeUpdate();

			if (status > 0) {

				PreparedStatement ps = con.prepareStatement("Delete from crime where crime_id = ?;");

				ps.setInt(1, id);

				int removed = ps.executeUpdate();

				if (removed > 0) {
					message = "FIR " + id + " Removed from Database...";

					PreparedStatement ps3 = con.prepareStatement("alter table crime auto_increment = ?;");
					ps3.setInt(1, id);

					ps3.executeUpdate();

				}

			} else {

				throw new CrimeException(
						"FIR " + id + " is not mapped to any Criminal. Perform Delete Unmapped records.");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
	}

//############################# Update Status Of FIR #############################
	@Override
	public String updateStatusOfFIR(int crime_id, String value) throws CrimeException {

		String message = "Failed to update the FIR";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("Select ? from crime;");
			ps.setInt(1, crime_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				try {

					PreparedStatement ps2 = con.prepareStatement("update crime set status = ? where crime_id = ?;");
					ps2.setString(1, value);
					ps2.setInt(2, crime_id);

					int status = ps2.executeUpdate();

					if (status > 0) {

						message = "Status of FIR " + crime_id + " Updated....";

					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw new CrimeException(e.getMessage());
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CrimeException(e.getMessage());

		}

		return message;

	}

//############################# Search FIR By ID #############################
	@Override
	public Crime searchFIRByID(int id) throws CrimeException {

		Crime c1 = null;

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("Select * from crime where crime_id = ?;");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Integer crimeId = rs.getInt("Crime_id");
				String name = rs.getString("Name_of_crime");
				Integer victim = rs.getInt("victims");
				String desc = rs.getString("detailed_des");
				String date = rs.getString("date");
				String sno = rs.getString("police_station_name");
				String suspect = rs.getString("Suspected");
				String status = rs.getString("Status");

				c1 = new Crime(crimeId, name, victim, desc, date, sno, suspect, status);

			} else {

				throw new CrimeException("Invalid FIR ID" + id);

			}

		} catch (SQLException e) {

			throw new CrimeException(e.getMessage());

		}

		return c1;

	}

//############################# Search FIR By Crime Type #############################
	@Override
	public List<Crime> searchFIRByCrimeType(String nm) throws CrimeException {

		List<Crime> list = new ArrayList<>();

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("Select * from crime where name_of_crime = ?;");
			ps.setString(1, nm);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("Crime_id");
				String name = rs.getString("Name_of_crime");
				Integer vic = rs.getInt("victims");
				String des = rs.getString("detailed_des");
				String date = rs.getString("date");
				String police = rs.getString("police_station_name");
				String sus = rs.getString("Suspected");
				String status = rs.getString("Status");

				Crime c1 = new Crime(id, name, vic, des, date, police, sus, status);
				list.add(c1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CrimeException(e.getMessage());
		}

		if (list.isEmpty()) {

			throw new CrimeException(nm + " not found in Database");

		}

		return list;

	}

//############################# Register Criminal #############################
	@Override
	public String addCriminalDetails(Criminal c) {

		String message = "Failed to Insert Criminal Record";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement(
					" insert into criminal (name,Address,gender,age,identity_mark,crime,area) values(?,?,?,?,?,?,?);");

			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getGender());
			ps.setInt(4, c.getAge());
			ps.setString(5, c.getIdentity_mark());
			ps.setString(6, c.getCrime());
			ps.setString(7, c.getArea());

			int insert = ps.executeUpdate();

			if (insert > 0) {

				message = "Criminal record Inserted into Database...";

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
	}

//############################# Get All Criminals #############################
	@Override
	public List<Criminal> getAllCriminals() throws CriminalException {

		List<Criminal> list = new ArrayList<>();

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("select * from Criminal;");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Integer id = rs.getInt("Criminal_id");
				String name = rs.getString("Name");
				Integer age = rs.getInt("age");
				String gender = rs.getString("gender");
				String add = rs.getString("Address");
				String mark = rs.getString("Identity_mark");
				String crime = rs.getString("crime");
				String area = rs.getString("area");

				Criminal c1 = new Criminal(id, name, add, age, gender, mark, crime, area);
				list.add(c1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CriminalException(e.getMessage());
		}

		if (list.isEmpty()) {

			throw new CriminalException();

		}

		return list;

	}

//############################# Delete Criminal Mapped To Crime #############################
	@Override
	public String deleteCriminalMappedToCrime(int id) throws CriminalException {

		String message = "Criminal Id " + id + " Not Present in Database";

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps1 = con.prepareStatement("Delete from crime_by_criminal where criminal_id = ?;");

			ps1.setInt(1, id);

			int status = ps1.executeUpdate();

			if (status > 0) {

				PreparedStatement ps = con.prepareStatement("Delete from criminal where criminal_id = ?;");

				ps.setInt(1, id);

				int delete = ps.executeUpdate();

				if (delete > 0) {

					message = "Criminal record of Criminal Id " + id + " Removed from Database...";

					PreparedStatement ps3 = con.prepareStatement("alter table criminal auto_increment = ?;");
					ps3.setInt(1, id);

					ps3.executeUpdate();

				}

			} else {

				throw new CriminalException("Criminal with ID " + id
						+ " is not mapped to any crime. You can Perform Delete Unmapped Record");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;

	}

//############################# Delete Criminal Not Mapped To Crime #############################
	@Override
	public String deleteCriminalNotMappedToCrime(int id) {

		String message = "Invalid Criminal Id " + id;

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("delete from criminal where criminal_id = ?;");
			ps.setInt(1, id);

			int status = ps.executeUpdate();

			if (status > 0) {

				message = "Details of Criminal id " + id + " Removed from Database...";

				PreparedStatement ps3 = con.prepareStatement("alter table criminal auto_increment = ?;");
				ps3.setInt(1, id);

				ps3.executeUpdate();

			}

		} catch (SQLException e) {

			message = e.getMessage();

		}

		return message;

	}

//############################# Search Criminal By Name #############################
	@Override
	public List<Criminal> searchCriminalByName(String s) throws CriminalException {

		List<Criminal> list = new ArrayList<>();

		try (Connection con = DBUtil.getconnection()) {

			PreparedStatement ps = con.prepareStatement("Select * from criminal where name = ?;");
			ps.setString(1, s);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("Criminal_id");
				String name = rs.getString("Name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String add = rs.getString("Address");
				String mark = rs.getString("Identity_mark");
				String crime = rs.getString("crime");
				String area = rs.getString("area");

				Criminal c = new Criminal(id, name, add, age, gender, mark, crime, area);
				list.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CriminalException(e.getMessage());
		}

		if (list.isEmpty()) {
			throw new CriminalException(s + " is not found in Database");
		}

		return list;

	}

//############################# Search Criminal By Id #############################
	@Override
	public Criminal searchCriminalByID(int id) throws CriminalException {

		Criminal c = null;

		try (Connection con = DBUtil.getconnection()) {
			PreparedStatement ps = con.prepareStatement("Select * from criminal where criminal_id = ?;");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int Cid = rs.getInt("Criminal_id");
				String name = rs.getString("Name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String add = rs.getString("Address");
				String mark = rs.getString("Identity_mark");
				String crime = rs.getString("crime");
				String area = rs.getString("area");

				c = new Criminal(Cid, name, add, age, gender, mark, crime, area);

			} else {

				throw new CriminalException("Invalid FIR ID " + id);

			}

		} catch (SQLException e) {

			throw new CriminalException(e.getMessage());

		}

		return c;

	}
	
	//############################# Details Of Solved Cases #############################
		@Override
		public List<Crime> detailsOfSolvedFIR() throws CrimeException {

			List<Crime> list = new ArrayList<>();

			try (Connection con = DBUtil.getconnection()) {

				PreparedStatement ps = con.prepareStatement("select * from crime where status = ?;");
				ps.setString(1, "solved");

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Integer id = rs.getInt("Crime_id");
					String name = rs.getString("Name_of_crime");
					Integer vic = rs.getInt("victims");
					String des = rs.getString("detailed_des");
					String date = rs.getString("date");
					String police = rs.getString("police_station_name");
					String sus = rs.getString("Suspected");
					String status = rs.getString("Status");

					Crime c1 = new Crime(id, name, vic, des, date, police, sus, status);
					list.add(c1);

				}

			} catch (SQLException e) {

				throw new CrimeException(e.getMessage());

			}

			if (list.isEmpty()) {

				throw new CrimeException("There is no solved Cases present into the Database");

			}

			return list;

		}

	//############################# Details Of Un-Solved Cases #############################
		@Override
		public List<Crime> detailsOfUnsolvedFIR() throws CrimeException {

			List<Crime> list = new ArrayList<>();

			try (Connection con = DBUtil.getconnection()) {

				PreparedStatement ps = con.prepareStatement("select * from crime where status = ?;");
				ps.setString(1, "unsolved");

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Integer id = rs.getInt("Crime_id");
					String name = rs.getString("Name_of_crime");
					Integer victim = rs.getInt("victims");
					String desc = rs.getString("detailed_des");
					String date = rs.getString("date");
					String sno = rs.getString("police_station_name");
					String suspect = rs.getString("Suspected");
					String status = rs.getString("Status");

					Crime c1 = new Crime(id, name, victim, desc, date, sno, suspect, status);
					list.add(c1);

				}

			} catch (SQLException e) {

				throw new CrimeException(e.getMessage());

			}

			if (list.isEmpty()) {

				throw new CrimeException("No Unsolved Cases in the Database");

			}

			return list;

		}

}
