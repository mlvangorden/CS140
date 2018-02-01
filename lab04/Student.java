package lab04;

public class Student{
	private int id;
	private String name;

	public Student(int ident, String nombre){
		id = ident;
		name = nombre;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}
}
