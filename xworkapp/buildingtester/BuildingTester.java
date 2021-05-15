package com.xworkz.xworkapp.buildingtester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.xworkapp.building.TallestBuildingDTO;
import com.xworkz.xworkapp.dao.TallestBuildingDAO;
import com.xworkz.xworkapp.dao.TallestBuildingImpli;

import lombok.NonNull;

public class BuildingTester {
	
	
	public static void main(String[] args) throws SQLException {
		TallestBuildingDTO dto = new TallestBuildingDTO(13,"Bur",828,"Emaar prop","17/jan/2009","UAE");
		TallestBuildingDTO dto2 = new TallestBuildingDTO(12,"Bur",828,"Emaar prop","17/jan/2009","UAE");
   List<TallestBuildingDTO> list=new ArrayList<TallestBuildingDTO>();
   list.add(dto);
   list.add(dto2);
		
		TallestBuildingDAO impli = new TallestBuildingImpli();
		//impli.save(dto2);
	//  impli.updateLengthByName("Bur Khalija", 1234.00);
		//impli.save(list);
		//impli.fetchTopFive();
		//impli.fetchByName("Bur");
        //impli.fetchByGreaterLength(1234.00);
         impli.fetchByMaxTopFiveLength(827.00);
	}

}
