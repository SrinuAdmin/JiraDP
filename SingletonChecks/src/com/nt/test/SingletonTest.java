package com.nt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.nt.singleton.Printer;

public class SingletonTest {

	public static void main1(String[] args) throws CloneNotSupportedException {
		
		Printer p=Printer.getPrinter("hello");
		Printer p1=Printer.getPrinter("BYE");
		
		Printer p2=(Printer) p.clone();
		
		p.showMsg();
		p1.showMsg();
		
		System.out.println(p.hashCode()+"  "+p1.hashCode()+"  "+p2.hashCode());
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Printer p=Printer.getPrinter("Hello");
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("prinetr.ser"));
		oos.writeObject(p);
		System.out.println("done");
		oos.close();
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("prinetr.ser"));
		Printer p1=(Printer) ois.readObject();
		p1.showMsg();
		//p1.showMsg();
		
		System.out.println(p.hashCode()+" "+p1.hashCode());
		ois.close();
	}
	
	
}
