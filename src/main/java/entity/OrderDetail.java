package entity;

import java.math.BigDecimal;

public class OrderDetail {
	private int orderId;
	private int orderDetailId;
	private String productName;
	private BigDecimal priceEach;
	private int quantity;
	public OrderDetail() {
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productName = productName;
		this.priceEach = priceEach;
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(BigDecimal priceEach) {
		this.priceEach = priceEach;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderId=" + orderId + ", orderDetailId=" + orderDetailId + ", productName=" + productName
				+ ", priceEach=" + priceEach + ", quantity=" + quantity + "]";
	}
	
	
}
