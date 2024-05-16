package com.exterro.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.exterro.hibernate.entity.HibernateEntity;
public class App {
	public static void main(String[] args) {
		try  {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();

			// Create a Criteria object
			Criteria criteria = session.createCriteria(HibernateEntity.class);
			
			// get all users
			List<HibernateEntity> emplist = criteria.list(); 
			for (HibernateEntity emp : emplist) {
				System.out.println("Id :"+emp.getId()+",Age :"+emp.getAge()+",Name :"+emp.getName());
			
			}
			
			// get a specific user
			Criteria criteria1 = session.createCriteria(HibernateEntity.class).add(Restrictions.eq("id",new Long(3)));
			HibernateEntity emp = (HibernateEntity) criteria1.uniqueResult();
			System.out.println("Age :"+emp.getAge()+",Name :"+emp.getName());
			
			
            sessionFactory.close();
//			
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
