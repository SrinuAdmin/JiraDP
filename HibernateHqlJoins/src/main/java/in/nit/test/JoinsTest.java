package in.nit.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.nit.model.Address;
import in.nit.model.Product;
import in.nit.util.Hibernateutil;

public class JoinsTest {

	public static void main1(String[] args) {

		SessionFactory sf = Hibernateutil.getSf();
		Session ses = sf.openSession();
		Transaction tx = null;
		try (ses) {
			tx = ses.beginTransaction();
//			Address addr3 = new Address();
//			addr3.setHno(352);
//			addr3.setArea("dfsvdsd");
//			addr3.setPinCode(39832);
//			ses.save(addr3);

			Product p = new Product();
			p.setProdId(5413);
			p.setProdCost(43223.32);
			p.setProdName("FDEFE");
			ses.save(p);
			tx.commit();
			System.out.println("Done");

		} catch (Exception e) {
			if (tx == null || tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SessionFactory sf = Hibernateutil.getSf();
		Session ses = sf.openSession();
		Transaction tx = null;
		try (ses) {
			tx = ses.beginTransaction();

			String hql = "select p.prodId,adds.hno from in.nit.model.Product p  full join p.addr as adds";

			Query q = ses.createQuery(hql);
			List<Object[]> list = q.list();
			list.forEach(ob -> {
				System.out.println(ob[0] + "  " + ob[1]);

			});

		} catch (Exception e) {
			if (tx == null || tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}
}
