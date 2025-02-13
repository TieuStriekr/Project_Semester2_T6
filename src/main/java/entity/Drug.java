package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Drug {
	private int id;
	private String typeId;
	private String name;
	private int quantity;
	private String unit;
	private BigDecimal price;
	private String usage;
	private String manufacturers;
	private LocalDate manuDay;
	private LocalDate expire;
	private boolean status;
	public Drug() {
		super();
		this.id = id;
		this.typeId = typeId;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.usage = usage;
		this.manufacturers = manufacturers;
		this.manuDay = manuDay;
		this.expire = expire;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}
	public LocalDate getManuDay() {
		return manuDay;
	}
	public void setManuDay(LocalDate manuDay) {
		this.manuDay = manuDay;
	}
	public LocalDate getExpire() {
		return expire;
	}
	public void setExpire(LocalDate expire) {
		this.expire = expire;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Drug [id=" + id + ", typeId=" + typeId + ", name=" + name + ", quantity=" + quantity + ", unit=" + unit
				+ ", price=" + price + ", usage=" + usage + ", manufacturers=" + manufacturers + ", manuDay=" + manuDay
				+ ", expire=" + expire + ", status=" + status + "]";
	}
}
