package com.xworkz.xworkapp.buildingtester;

import java.sql.SQLException;

import com.xworkz.xworkapp.building.TallestBuildingDTO;
import com.xworkz.xworkapp.dao.TallestBuildingDAO;
import com.xworkz.xworkapp.dao.TallestBuildingImpli;

public class BuildingTester {
	
	
	public static void main(String[] args) throws SQLException {
		TallestBuildingDTO dto = new TallestBuildingDTO(6,"Bur",828,"Emaar prop","17/jan/2009","UAE");
		
		
		TallestBuildingDAO impli = new TallestBuildingImpli();
		//impli.save(dto);
		//impli.updateLengthByName("Burj Khalija", 820);
		//impli.save(dto);
		//impli.fetchByName("Bur");
		//impli.fetchTopFive();
         //impli.fetchByGreaterLength(828.00);
impli.fetchByMaxTopFiveLength(827.00);
	}

}
