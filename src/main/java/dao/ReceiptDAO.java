package dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import database.ConnectDB;
import entity.Customer;
import entity.Drug;
import entity.OrderDetail;
import entity.Receipt;
import entity.User;

public class ReceiptDAO {
	public String getOrderId(int cusId,int pay, LocalDate orderDate, BigDecimal amount) {
	    String orderId= null;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getOrderId(?,?,?,?)}");
	    ) {
	        cs.setInt(1, cusId);
	        cs.setInt(2, pay);
	        cs.setDate(3, Date.valueOf(orderDate));
	        cs.setBigDecimal(4, amount);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	            orderId = rs.getString("id");
	        }
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Invalid Get Order Id",null, JOptionPane.ERROR_MESSAGE);
	    }
	    return orderId;
	}

	public void updateQuantityDrug(int drugId, int quantity) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateQuantityDrug(?,?)}");
				
			)
		{
			cs.setInt(1,drugId);
			cs.setInt(2, quantity);
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Update Quantity Successful":"Update nothing");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Update Quantity Drug",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public List<Receipt> selectReceipt(int cusId,LocalDate orderDate){
		List<Receipt> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getReceipt(?,?)}");
				) 
			{
		        cs.setInt(1, cusId);  
		        cs.setDate(2, Date.valueOf(orderDate)); 
				
				var rs = cs.executeQuery();
				while(rs.next()) {
					var receipt = new Receipt();
					receipt.setOrderDate(rs.getDate("orderDate").toLocalDate());
					receipt.setProductName(rs.getString("drug_name"));
					receipt.setQuantity(rs.getInt("quantity"));
					receipt.setUnit(rs.getString("unit"));
					receipt.setPriceEach(rs.getBigDecimal("priceEach"));
					list.add(receipt);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return list;
	}
	
	public BigDecimal amountReceipt(int cusId,LocalDate orderDate) {
		BigDecimal amount = null;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call allAmountReceipt(?,?)}");
			)
		{
			cs.setInt(1, cusId);
		    cs.setDate(2, Date.valueOf(orderDate));
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				amount = rs.getBigDecimal("totalAmount");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	public void insertCusCheck(Customer cus) {
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call checkCusExist(?,?,?)}")
			)
		{	
			cs.setString(1, cus.getName());
			cs.setBoolean(2, cus.getGender());
			cs.setInt(3, cus.getPhone());
			JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Insert Customer Successful":"Insert nothing");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Customer",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
