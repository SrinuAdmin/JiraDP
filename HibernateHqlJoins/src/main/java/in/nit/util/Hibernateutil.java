package in.nit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {

	private static SessionFactory sf=null;
	
	static {
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSf() {
		return sf;
	}
}
