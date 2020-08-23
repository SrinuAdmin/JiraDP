package com.nt.singleton;

import java.io.Serializable;

public class Printer implements Cloneable, Serializable {

	private static final long serialVersionUID = -5338926912445760150L;
	private static Printer p;

	private Printer() {
	}

	private static String data = null;

	public static Printer getPrinter(String msg) {
		data = msg;
		if (p == null) {
			synchronized (Printer.class) {
				if (p == null)
					p = new Printer();
			}
		}
		return p;
	}

	public void showMsg() {
		System.out.println(data);
	}

	// Problem part
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}

	//Deserailization blocker
	public Object readResolve() {
		throw new IllegalArgumentException("Deserialization not allowed here:");
		// return p;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return p;
		// throw new CloneNotSupportedException("Not supported over this method:");
	}

}
