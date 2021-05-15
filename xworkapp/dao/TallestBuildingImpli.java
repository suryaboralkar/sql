package com.xworkz.xworkapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.xworkz.xworkapp.building.TallestBuildingDTO;

public class TallestBuildingImpli implements TallestBuildingDAO {
	String url = "jdbc:mysql://localhost:3306/ building";
	String user = "root";
	String password = "root";
	BasicDataSource source = new BasicDataSource();

	@Override
	public void save(TallestBuildingDTO dto) throws SQLException {

		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "INSERT INTO  building.building_table VALUES (?,?,?,?,?,?)";

		try (Connection conn = source.getConnection(); PreparedStatement statement = conn.prepareStatement(sql);) {

			conn.setAutoCommit(false);
			statement.setInt(1, dto.getId());
			statement.setString(2, dto.getName());
			statement.setDouble(3, dto.getLength());
			statement.setString(4, dto.getConstructedBy());
			statement.setString(5, dto.getConstructedDate());
			statement.setString(6, dto.getCountry());
			statement.execute();
			conn.commit();

		}

	}

	@Override
	public void updateLengthByName(String name, double length) throws SQLException {

		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "update  building.building_table  set B_LENGTH =?  where  B_NAME=?";

		try (Connection conn = source.getConnection(); PreparedStatement statement = conn.prepareStatement(sql);) {

			conn.setAutoCommit(false);
			statement.setDouble(1, length);
			statement.setString(2, name);
			statement.execute();
			conn.commit();

		}

	}

	@Override
	public void save(List<TallestBuildingDTO> list) throws SQLException {
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "INSERT INTO  building.building_table VALUES (?,?,?,?,?,?)";

		try (Connection conn = source.getConnection(); PreparedStatement statement = conn.prepareStatement(sql);) {
			conn.setAutoCommit(false);
			Iterator<TallestBuildingDTO> iterator = list.iterator();
			while (iterator.hasNext()) {
				TallestBuildingDTO dto = iterator.next();
				statement.setInt(1, dto.getId());
				statement.setString(2, dto.getName());
				statement.setDouble(3, dto.getLength());
				statement.setString(4, dto.getConstructedBy());
				statement.setString(5, dto.getConstructedDate());
				statement.setString(6, dto.getCountry());

				statement.execute();

			}

			conn.commit();
		}

	}

	@Override
	public TallestBuildingDTO fetchByName(String name) throws SQLException {
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "select * from building.building_table where B_NAME=?";
		try (Connection conn = source.getConnection(); PreparedStatement stat = conn.prepareStatement(sql);) {
        	stat.setString(1, name);
			boolean execute = stat.execute();
			if (execute) {
				ResultSet set = stat.getResultSet();
				set.next();
				int id = set.getInt(1);
				String name1 = set.getString(2);
				double length = set.getDouble(3);
				String consby = set.getNString(4);
				String consdate = set.getNString(5);
				String country = set.getString(6);

				TallestBuildingDTO dto = new TallestBuildingDTO();
				dto.setId(id);
				dto.setName(name1);
				dto.setLength(length);
				dto.setConstructedBy(consby);
				dto.setConstructedDate(consdate);
				dto.setCountry(country);
				System.out.println(dto);

			}

		}
		return null;
	}

	@Override
	public List<TallestBuildingDTO> fetchTopFive() throws SQLException {
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "select * from building.building_table where B_ID<8";

		try (Connection conn = source.getConnection(); PreparedStatement stat = conn.prepareStatement(sql);) {
			source.setUrl(url);
			source.setUsername(user);
			source.setPassword(password);

			boolean execute = stat.execute();
			ResultSet set = stat.getResultSet();
			while (set.next()) {
				int id = set.getInt("B_ID");
				String name = set.getString("B_NAME");
				double length = set.getDouble("B_LENGTH");
				String constructedby = set.getString("B_CONSTRUCTEDBY");
				String constructeddate = set.getString("B_CONSTRUCTEDDATE");
				String coutry = set.getString("B_COUNTRY");
				TallestBuildingDTO dto = new TallestBuildingDTO(id, name, length, constructedby, constructeddate,
						coutry);
				List list = new ArrayList();
				list.add(dto);
				System.out.println(list);
			}
		}
		return null;
	}

	@Override
	public List<TallestBuildingDTO> fetchByGreaterLength(Double length) throws SQLException {
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "select * from building.building_table where B_LENGTH=?";

		try (Connection conn = source.getConnection(); PreparedStatement stat = conn.prepareStatement(sql);) {
			stat.setDouble(1, length);
			boolean execute = stat.execute();
			if (execute) {
				ResultSet set = stat.getResultSet();
				set.next();
				int id = set.getInt(1);
				String name = set.getString(2);
				double length1 = set.getDouble(3);
				String consby = set.getNString(4);
				String consdate = set.getNString(5);
				String country = set.getString(6);
				TallestBuildingDTO dto = new TallestBuildingDTO();
				dto.setId(id);
				dto.setName(name);
				dto.setLength(length1);
				dto.setConstructedBy(consby);
				dto.setConstructedDate(consdate);
				dto.setCountry(country);
				List list = new ArrayList();
				list.add(dto);
				System.out.println(list);

			}

		}

		return null;
	}

	@Override
	public List<TallestBuildingDTO> fetchByMaxTopFiveLength(double length) throws SQLException {
		source.setUrl(url);
		source.setUsername(user);
		source.setPassword(password);
		String sql = "select B_LENGTH from building.building_table order by B_LENGTH desc limit 5";
		try (Connection conn = source.getConnection(); PreparedStatement stat = conn.prepareStatement(sql);) {
			boolean execute = stat.execute();
			if (execute) {
				ResultSet set = stat.getResultSet();
				set.next();
				int id = set.getInt(1);
				

				TallestBuildingDTO dto = new TallestBuildingDTO();
				dto.setId(id);
				
				List list = new ArrayList();
				list.add(dto);
				System.out.println(list);

			}

		}
		return null;
	}

}
