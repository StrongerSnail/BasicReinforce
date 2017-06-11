package day01;

public class Student {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 判断两个对象事都相等
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) 
			return false;
		if(this == obj)
			return true;
		if(this.getClass() != obj.getClass())
			return false;
		
		final Student s = (Student) obj;
		
		if(id != s.id)
			return false;
		if(name != s.name)
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
