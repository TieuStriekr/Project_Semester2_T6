package dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;

import entity.OrderDetail;


public class OrderDetailDAO {
	public List<OrderDetail> selectOrderDetail(int pageNumber, int rowOfPage){
		List<OrderDetail> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getOrderDetail(?,?)}");
				) 
			{
				cs.setInt(1,pageNumber);
				cs.setInt(2, rowOfPage);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var detail = new OrderDetail();
					detail.setOrderDetailId(rs.getInt("id"));
					detail.setOrderId(rs.getInt("orderId"));
					detail.setProductName(rs.getString("drug_name"));
					detail.setPriceEach(rs.getBigDecimal("priceEach"));
					detail.setQuantity(rs.getInt("quantity"));
					list.add(detail);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return list;
	}
	
	public int countOrderDetail() {
		int count = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countOrderDetail}");
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
	
	public void insertOrderDetail(OrderDetail detail) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call insertOrderDetail(?,?,?,?)}");	
			)
		
		{
			cs.setInt(1, detail.getOrderId());
			cs.setInt(2, Integer.parseInt(detail.getProductName()));
			cs.setBigDecimal(3, detail.getPriceEach());
			cs.setInt(4, detail.getQuantity());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert Order Detail Successful":"Insert nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Insert Order Detail",null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void updateOrderDetail(OrderDetail detail) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateOrderDetail(?,?,?,?,?)}");	
			)
		
		{
			cs.setInt(1, detail.getOrderId());
			cs.setInt(2, Integer.parseInt(detail.getProductName()));
			cs.setBigDecimal(3, detail.getPriceEach());
			cs.setInt(4, detail.getQuantity());
			cs.setInt(5, detail.getOrderDetailId());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update Order Detail",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteOrderDetail(int id) {
		try (
				var con = ConnectDB.getCon();
		        var cs = con.prepareCall("{call deleteOrderDetail(?)}");
			){
			cs.setInt(1,id);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Delete successful":"Delete nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Delete Order Detail",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<OrderDetail> searchOrderId(int orderId){
		List<OrderDetail> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call searchOrderId(?)}");
				) 
			{
				cs.setInt(1,orderId);
				var rs = cs.executeQuery();
				while(rs.next()) {
					var detail = new OrderDetail();
					detail.setOrderDetailId(rs.getInt("id"));
					detail.setOrderId(rs.getInt("order_id"));
					detail.setProductName(rs.getString("pro_name"));
					detail.setPriceEach(rs.getBigDecimal("price_each"));
					detail.setQuantity(rs.getInt("quantity"));
					list.add(detail);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Search Order Id",null, JOptionPane.ERROR_MESSAGE);
			}
			return list;
	}
	
	public String getProIdByProName(String proName) {
	    String proId =null;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getDrugIdDetail(?)}");
	    ) {
	        cs.setString(1, proName);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	            proId = rs.getString("id");
	        }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Invalid Product Id",null, JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	    return proId;
	}
	
}
