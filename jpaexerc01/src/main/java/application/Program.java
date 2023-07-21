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
		
		
		Person p1 = em.find(Person.class, 1);
		
		System.out.println(p1);
		
		em.close();
		emf.close();
 
	}

}
