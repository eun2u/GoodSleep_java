import java.util.Vector;
public class Person {
	public String name;
	public int age;
	public String id;
	public String gender;
	
	public Person()
	{
		name = null;
		age = 0;
		id = null;
		gender = null;
	}
	public Person(String name, int age, String id, String gender) {
		
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Vector<Object> getall() {
		Vector<Object> myvector = new Vector<Object>();
		myvector.add(name);
		myvector.add(age);
		myvector.add(id);
		myvector.add(gender);
		return myvector;
	}
}
