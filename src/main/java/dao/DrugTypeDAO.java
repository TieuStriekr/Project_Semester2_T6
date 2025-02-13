package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.DrugType;


public class DrugTypeDAO {
	public List<DrugType> selectDrugType(int pageNumber, int rowOfPage){
		List<DrugType> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getDrugType(?,?)}");
				) 
			{
				cs.setInt(1,pageNumber);
				cs.setInt(2, rowOfPage);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var type = new DrugType();
					type.setId(rs.getString("id"));
					type.setName(rs.getString("typeName"));
					list.add(type);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public int countDrugType() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countDrugType}");
				ResultSet rs = cs.executeQuery();
			){
			while(rs.next()) {
				count = rs.getInt("total");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public void insertType(DrugType type) {
		try
			(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertDrugType(?,?)}");	
			)
		{
			cs.setString(1, type.getId());
			cs.setString(2, type.getName());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert successful":"Insert nothing");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid Insert Drug Type",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateType(DrugType type) {
		try
			(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateDrugType(?,?)}");	
			)
		{
			
			cs.setString(1, type.getName());
			cs.setString(2, type.getId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid Update Drug Type",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<DrugType> searchTypeId(String id){
		List<DrugType> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchTypeId(?)}");
				) 
			{
				cs.setString(1,id);
				
				var rs = cs.executeQuery();
				while(rs.next()) {
					var type = new DrugType();
					type.setId(rs.getString("id"));
					type.setName(rs.getString("typeName"));
					list.add(type);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Type ID",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public List<DrugType> searchTypeName(String typeName){
		List<DrugType> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchTypeName(?)}");
				) 
			{
				cs.setString(1,typeName);
				
				var rs = cs.executeQuery();
				while(rs.next()) {
					var type = new DrugType();
					type.setId(rs.getString("id"));
					type.setName(rs.getString("typeName"));
					list.add(type);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Type Name",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
}
