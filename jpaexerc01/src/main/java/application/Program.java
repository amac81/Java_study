package application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;
import javax.persistence.EntityManager;

public class Program {

	public static void main(String[] args) {
		//persistence xml /src/main/resources/META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		Person p = em.find(Person.class, 2);
		//any operation other than a simple query needs to be transactional
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		System.out.println("Done");
 
	}

}
