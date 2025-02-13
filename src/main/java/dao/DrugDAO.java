package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.Drug;

public class DrugDAO {
	public List<Drug>  selectDrug(int pageNumber, int rowOfPage) {
		List<Drug> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call getDrug(?,?)}");
			) 
		{
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			var rs = cs.executeQuery();
			while(rs.next()) {
				var drug = new Drug();
				drug.setId(rs.getInt("id"));
				drug.setTypeId(rs.getString("typeId"));
				drug.setName(rs.getString("drug_name"));
				drug.setQuantity(rs.getInt("quantity"));
				drug.setUnit(rs.getString("unit"));
				drug.setPrice(rs.getBigDecimal("drug_price"));
				drug.setUsage(rs.getString("usage"));
				drug.setManufacturers(rs.getString("manu_name"));
				drug.setManuDay(rs.getDate("manuDay").toLocalDate());
				drug.setExpire(rs.getDate("expireDay").toLocalDate());
				drug.setStatus(rs.getBoolean("drugStatus"));
				list.add(drug);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Show Data",null, JOptionPane.ERROR_MESSAGE);
				
		}
		return list;
	}
	
	public int countDrug() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countDrug}");
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
	
	public void updateDrug(Drug drug) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateDrug(?,?,?,?,?,?,?,?,?,?,?)}");
				
			)
		{
			cs.setString(1,drug.getTypeId());
			cs.setString(2, drug.getName());	
			cs.setInt(3, drug.getQuantity());
			cs.setString(4,drug.getUnit());	
			cs.setBigDecimal(5, drug.getPrice());
			cs.setString(6,drug.getUsage());
			cs.setInt(7, Integer.parseInt(drug.getManufacturers()));
			cs.setDate(8, Date.valueOf(drug.getManuDay()));
			cs.setDate(9, Date.valueOf(drug.getExpire()));
			cs.setBoolean(10,drug.isStatus());
			cs.setInt(11, drug.getId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertDrug(Drug drug) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertDrug(?,?,?,?,?,?,?,?,?,?)}");
				
			)
		{
			cs.setString(1,drug.getTypeId());
			cs.setString(2, drug.getName());	
			cs.setInt(3, drug.getQuantity());
			cs.setString(4,drug.getUnit());	
			cs.setBigDecimal(5, drug.getPrice());
			cs.setString(6,drug.getUsage());
			cs.setInt(7, Integer.parseInt(drug.getManufacturers()));
			cs.setDate(8, Date.valueOf(drug.getManuDay()));
			cs.setDate(9, Date.valueOf(drug.getExpire()));
			cs.setBoolean(10,drug.isStatus());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert successful":"Insert nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Insert",null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void deleteDrug(int id) {
		try (
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call deleteDrug(?)}");
			){
			cs.setInt(1,id);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Delete successful":"Delete nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Delete",null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public List<Drug> searchDrug(String drugName) {
		List<Drug> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call searchDrug(?)}");
			) 
		
		{
			cs.setString(1, drugName);
			var rs = cs.executeQuery();
			while(rs.next()) {
				var drug = new Drug();
				drug.setId(rs.getInt("id"));
				drug.setTypeId(rs.getString("typeId"));
				drug.setName(rs.getString("drug_name"));
				drug.setQuantity(rs.getInt("quantity"));
				drug.setUnit(rs.getString("unit"));
				drug.setPrice(rs.getBigDecimal("drug_price"));
				drug.setUsage(rs.getString("usage"));
				drug.setManufacturers(rs.getString("manu_name"));
				drug.setManuDay(rs.getDate("manuDay").toLocalDate());
				drug.setExpire(rs.getDate("expireDay").toLocalDate());
				drug.setStatus(rs.getBoolean("drugStatus"));
				list.add(drug);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Search Drug Name",null, JOptionPane.ERROR_MESSAGE);
		}
		return list;
	}
	
	public List<Drug> searchType(String type) {
		List<Drug> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call searchType(?)}");
			) 
		
		{
			cs.setString(1, type);
			var rs = cs.executeQuery();
			while(rs.next()) {
				var drug = new Drug();
				drug.setId(rs.getInt("id"));
				drug.setTypeId(rs.getString("typeId"));
				drug.setName(rs.getString("drug_name"));
				drug.setQuantity(rs.getInt("quantity"));
				drug.setUnit(rs.getString("unit"));
				drug.setPrice(rs.getBigDecimal("drug_price"));
				drug.setUsage(rs.getString("usage"));
				drug.setManufacturers(rs.getString("manu_name"));
				drug.setManuDay(rs.getDate("manuDay").toLocalDate());
				drug.setExpire(rs.getDate("expireDay").toLocalDate());
				drug.setStatus(rs.getBoolean("drugStatus"));
				list.add(drug);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Search Type",null, JOptionPane.ERROR_MESSAGE);
		}
		return list;
	}
	
	public List<Drug> searchUsage(String usage) {
		List<Drug> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call searchUsage(?)}");
			) 
		
		{
			cs.setString(1, usage);
			var rs = cs.executeQuery();
			while(rs.next()) {
				var drug = new Drug();
				drug.setId(rs.getInt("id"));
				drug.setTypeId(rs.getString("typeId"));
				drug.setName(rs.getString("drug_name"));
				drug.setQuantity(rs.getInt("quantity"));
				drug.setUnit(rs.getString("unit"));
				drug.setPrice(rs.getBigDecimal("drug_price"));
				drug.setUsage(rs.getString("usage"));
				drug.setManufacturers(rs.getString("manu_name"));
				drug.setManuDay(rs.getDate("manuDay").toLocalDate());
				drug.setExpire(rs.getDate("expireDay").toLocalDate());
				drug.setStatus(rs.getBoolean("drugStatus"));
				list.add(drug);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Search Usage",null, JOptionPane.ERROR_MESSAGE);
		}
		return list;
	}
	
	public List<Drug> checkExpire(int month) {
		List<Drug> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call checkExpireDay(?)}");
			) 
		{
			cs.setInt(1, month);
			var rs = cs.executeQuery();
			while(rs.next()) {
				var drug = new Drug();
				drug.setId(rs.getInt("id"));
				drug.setTypeId(rs.getString("typeId"));
				drug.setName(rs.getString("drug_name"));
				drug.setQuantity(rs.getInt("quantity"));
				drug.setUnit(rs.getString("unit"));
				drug.setPrice(rs.getBigDecimal("drug_price"));
				drug.setUsage(rs.getString("usage"));
				drug.setManufacturers(rs.getString("manu_name"));
				drug.setManuDay(rs.getDate("manuDay").toLocalDate());
				drug.setExpire(rs.getDate("expireDay").toLocalDate());
				drug.setStatus(rs.getBoolean("drugStatus"));
				list.add(drug);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid Check Expire",null, JOptionPane.ERROR_MESSAGE);
		}
		return list;	
	}
	
	public String getManuIdByName(String manuName) {
	    String manuId =null;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getManuName(?)}");
	    ) {
	        cs.setString(1, manuName);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	        	manuId = rs.getString("id");
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Invalid Check Expire",null, JOptionPane.ERROR_MESSAGE);
	    }
	    return manuId;
	}
}
