package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.Supplier;


public class SupplierDAO {
	public List<Supplier> selectManu(int pageNumber, int rowOfPage){
		List<Supplier> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getManu(?,?)}");
				) 
			{
				cs.setInt(1,pageNumber);
				cs.setInt(2, rowOfPage);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var manu = new Supplier();
					manu.setId(rs.getInt("id"));
					manu.setName(rs.getString("manu_name"));
					manu.setAddress(rs.getString("manu_address"));
					manu.setPhone(rs.getInt("manu_phone"));
					list.add(manu);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public int countManu() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countManu}");
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
	
	public void insertManu(Supplier manu) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertManu(?,?,?)}");	
			)
		
		{
			cs.setString(1, manu.getName());
			cs.setString(2, manu.getAddress());
			cs.setInt(3, manu.getPhone());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert successful":"Insert nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Insert Supplier",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateManu(Supplier manu) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateManu(?,?,?,?)}");	
			)
		
		{
			cs.setString(1, manu.getName());
			cs.setString(2, manu.getAddress());
			cs.setInt(3, manu.getPhone());
			cs.setInt(4, manu.getId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update Supplier",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteManu(int id) {
		try (
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call deleteManu(?)}");
			){
			cs.setInt(1,id);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Delete successful":"Delete nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Delete Supplier",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<Supplier> searchManuName(String manuName){
		List<Supplier> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchManuName(?)}");
				) 
			{
				cs.setString(1,manuName);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var manu = new Supplier();
					manu.setId(rs.getInt("id"));
					manu.setName(rs.getString("manu_name"));
					manu.setAddress(rs.getString("manu_address"));
					manu.setPhone(rs.getInt("manu_phone"));
					list.add(manu);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Supplier Name",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public List<Supplier> searchManuPhone(int manuPhone){
		List<Supplier> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchManuPhone(?)}");
				) 
			{
				cs.setInt(1,manuPhone);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var manu = new Supplier();
					manu.setId(rs.getInt("id"));
					manu.setName(rs.getString("manu_name"));
					manu.setAddress(rs.getString("manu_address"));
					manu.setPhone(rs.getInt("manu_phone"));
					list.add(manu);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Supplier Phone",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
}
