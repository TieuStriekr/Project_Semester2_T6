package entity;

public class DrugType {
	private String id;
	private String name;
	public DrugType() {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DrugType [id=" + id + ", name=" + name + "]";
	}
	
}
