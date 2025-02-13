package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.Customer;


public class CustomerDAO {
	public List<Customer> selectCus(int pageNumber, int rowOfPage){
		List<Customer> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getCus(?,?)}");
				) 
			{
				cs.setInt(1,pageNumber);
				cs.setInt(2, rowOfPage);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var cus = new Customer();
					cus.setId(rs.getInt("id"));
					cus.setName(rs.getString("cus_name"));
					cus.setGender(rs.getBoolean("gender"));
					cus.setPhone(rs.getInt("cus_phone"));
					list.add(cus);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public int countCus() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countCus}");
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
	
	public void insertCus(Customer cus) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertCus(?,?,?)}");	
			)
		
		{
			cs.setString(1, cus.getName());
			cs.setBoolean(2, cus.getGender());
			cs.setInt(3, cus.getPhone());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert Customer Successful":"Insert nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Insert Customer",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void updateCus(Customer cus) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateCus(?,?,?,?)}");	
			)
		
		{
			cs.setString(1, cus.getName());
			cs.setBoolean(2, cus.getGender());
			cs.setInt(3, cus.getPhone());
			cs.setInt(4, cus.getId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update Customer",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteCus(int id) {
		try (
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call deleteCus(?)}");
			){
			cs.setInt(1,id);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Delete successful":"Delete nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Delete Customer",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<Customer> searchCusName(String cusName){
		List<Customer> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchCusName(?)}");
				) 
			{
				cs.setString(1,cusName);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var cus = new Customer();
					cus.setId(rs.getInt("id"));
					cus.setName(rs.getString("cus_name"));
					cus.setGender(rs.getBoolean("gender"));
					cus.setPhone(rs.getInt("cus_phone"));
					list.add(cus);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Customer Name",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public List<Customer> searchCusPhone(int cusPhone){
		List<Customer> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchCusPhone(?)}");
				) 
			{
				cs.setInt(1,cusPhone);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var cus = new Customer();
					cus.setId(rs.getInt("id"));
					cus.setName(rs.getString("cus_name"));
					cus.setGender(rs.getBoolean("gender"));
					cus.setPhone(rs.getInt("cus_phone"));
					list.add(cus);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Customer Phone",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
}
