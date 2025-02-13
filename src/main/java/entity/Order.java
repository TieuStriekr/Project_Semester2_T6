package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
	private int id;
	private String cusName;
	private String payType;
	private LocalDate orderDate;
	private BigDecimal amountPaid;
	public Order() {
		this.id = id;
		this.cusName = cusName;
		this.payType = payType;
		this.orderDate = orderDate;
		this.amountPaid = amountPaid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", cusName=" + cusName + ", payType=" + payType + ", orderDate=" + orderDate
				+ ", amountPaid=" + amountPaid + "]";
	}
}
