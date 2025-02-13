package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StatisticEn {
	private LocalDate orderDate;
	private String productName;
	private int quantity;
	private String unit;
	private BigDecimal priceEach;
	public StatisticEn() {
		super();
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantity = quantity;
		this.unit = unit;
		this.priceEach = priceEach;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}
	@Override
	public String toString() {
		return "StatisticEn [orderDate=" + orderDate + ", productName=" + productName + ", quantity=" + quantity
				+ ", unit=" + unit + ", priceEach=" + priceEach + "]";
	}
	
}
