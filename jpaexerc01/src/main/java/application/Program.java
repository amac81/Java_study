package application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;
import javax.persistence.EntityManager;

public class Program {

	public static void main(String[] args) {
		Person p1 = new Person(null, "Jonh Bill", "jonh@gmail.com");
		Person p2 = new Person(null, "Mary Brown", "mary@gmail.com");
		Person p3 = new Person(null, "Billy Bob", "billy@gmail.com");

		//persistence xml /src/main/resources/META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		System.out.println("done!");
		
 
	}

}
