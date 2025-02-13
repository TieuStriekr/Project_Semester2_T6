package dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConnectDB;
import entity.StatisticEn;


public class StatisticDAO {
	public List<StatisticEn> selectReceipt(LocalDate orderDate){
		List<StatisticEn> list = new ArrayList<>();
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call getStatistic(?)}");
				) 
			{  
		        cs.setDate(1, Date.valueOf(orderDate)); 
				
				var rs = cs.executeQuery();
				while(rs.next()) {
					var statistic = new StatisticEn();
					statistic.setOrderDate(rs.getDate("orderDate").toLocalDate());
					statistic.setProductName(rs.getString("drug_name"));
					statistic.setQuantity(rs.getInt("quantity"));
					statistic.setUnit(rs.getString("unit"));
					statistic.setPriceEach(rs.getBigDecimal("priceEach"));
					list.add(statistic);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid show data",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			return list;
	}
	
	public BigDecimal amountStatistic(LocalDate orderDate) {
		BigDecimal amount = null;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call allAmountStatistic(?)}");
			)
		{
		    cs.setDate(1, Date.valueOf(orderDate));
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				amount = rs.getBigDecimal("totalAmountStatistic");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}
	
	public int quantityStatistic(LocalDate orderDate) {
		int quantity = 0;
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call allQuantityStatistic(?)}");
			)
		{
		    cs.setDate(1, Date.valueOf(orderDate));
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				quantity = rs.getInt("totalQuantityStatic");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}
}
