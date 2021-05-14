package com.xworkz.xworkapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkapp.building.TallestBuildingDTO;

public interface TallestBuildingDAO {
	public void save(TallestBuildingDTO dto) throws SQLException;
	public void save(List<TallestBuildingDTO>  dto) throws SQLException;
	public void updateLengthByName(String name,double length) throws SQLException;
    public TallestBuildingDTO fetchByName(String name) throws SQLException;
	public List<TallestBuildingDTO> fetchTopFive() throws SQLException;
	public List<TallestBuildingDTO> fetchByGreaterLength(Double length) throws SQLException;
	public List<TallestBuildingDTO> fetchByMaxTopFiveLength(double length) throws SQLException;
	
	

}
