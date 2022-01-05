package ch16ch08io_2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable{
	int no;
	String name;
	String email;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(no);
		out.writeUTF(name);
		out.writeUTF(email);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		no = in.read();
		name = in.readUTF();
		email = in.readUTF();
		
	}
	public Person() {
		this(0,"","");
	}
	public Person(int no, String name, String email) {
		this.no = no;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return  no + ". 이름 : " + name + "\temail : " + email + "\n";
	}
	
}
