package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.Order;

public class OrderDAO {
	public List<Order> selectOrder(int pageNumber, int rowOfPage){
		List<Order> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getOrder(?,?)}");
				) 
			{
				cs.setInt(1,pageNumber);
				cs.setInt(2, rowOfPage);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var order = new Order();
					order.setId(rs.getInt("id"));
					order.setCusName(rs.getString("cus_name"));
					order.setPayType(rs.getString("payMode"));
					order.setOrderDate(rs.getDate("orderDate").toLocalDate());
					order.setAmountPaid(rs.getBigDecimal("amountPaid"));
					list.add(order);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return list;
	}
	
	public int countOrder() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countOrder}");
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
	
	public void insertOrder(Order order) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertOrder(?,?,?,?)}");	
			)
		
		{
			cs.setInt(1, Integer.parseInt(order.getCusName()));
			cs.setInt(2, Integer.parseInt(order.getPayType()));
			cs.setDate(3, Date.valueOf(order.getOrderDate()));
			cs.setBigDecimal(4,order.getAmountPaid());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert Order Successful":"Insert nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Insert Order",null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void updateOrder(Order order) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateOrder(?,?,?,?,?)}");	
			)
		
		{
			cs.setInt(1, Integer.parseInt(order.getCusName()));
			cs.setInt(2, Integer.parseInt(order.getPayType()));
			cs.setDate(3, Date.valueOf(order.getOrderDate()));
			cs.setBigDecimal(4,order.getAmountPaid());
			cs.setInt(5, order.getId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update Order",null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(int id) {
		try (
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call deleteOrder(?)}");
			){
			cs.setInt(1,id);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Delete successful":"Delete nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Delete Order",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<Order> searchCusName(String cusName){
		List<Order> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchOrderCus(?)}");
				) 
			{
				cs.setString(1,cusName);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var order = new Order();
					order.setId(rs.getInt("id"));
					order.setCusName(rs.getString("cus_name"));
					order.setPayType(rs.getString("payMode"));
					order.setOrderDate(rs.getDate("orderDate").toLocalDate());
					order.setAmountPaid(rs.getBigDecimal("amountPaid"));
					list.add(order);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Customer",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	public String getCusIdByCusName(String cusName) {
	    String cusId =null;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getCustomerOrder(?)}");
	    ) {
	        cs.setString(1, cusName);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	            cusId = rs.getString("id");
	        }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Invalid Get Customer Order",null, JOptionPane.ERROR_MESSAGE);
	    }
	    return cusId;
	}
	
	public String getPayIdByPayMode(String payMode) {
	    String payId =null;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getPayOrder(?)}");
	    ) {
	        cs.setString(1, payMode);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	            payId = rs.getString("id");
	        }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Invalid Get Payment",null, JOptionPane.ERROR_MESSAGE);
	    }
	    return payId;
	}
}
