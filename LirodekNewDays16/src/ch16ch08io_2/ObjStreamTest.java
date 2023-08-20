package ch16ch08io_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
class ObjCls{
	
	public void cls1() throws IOException, ClassNotFoundException {
		//ObjectInputStream 읽어옴, ObjectOutPutStream 기록
				File file = new File("C:\\Users\\user\\OneDrive\\새 폴더\\Person.dat");
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Person data1 = new Person(1,"배광민","Lirodek@gmail.com");
				Person data2 = new Person(2,"이광민","Lirodek0106@gmail.com");
				Person data3 = new Person(3,"최강민","kalkulza@gmail.com");
				
				
				ArrayList<Person> list = new ArrayList<Person>();
				list.add(data1);
				list.add(data2);
				list.add(data3);

				oos.writeObject(list);
				System.out.println("객체 저장 완료");
				
				ArrayList<Person> list2 = (ArrayList<Person>) ois.readObject();
				Iterator<Person> itr =list2.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
				
	}
}
public class ObjStreamTest {
	public static ObjCls objcls  = new ObjCls();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		objcls.cls1();
	}

}
