package org.mairie.comores.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mairie.comores.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeDaoTest{
	@Autowired 
	private TestEntityManager entityManager;
	
	@Autowired
	private  EmployeRepository dao;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date1 = null;
	Date date2 = null;
	Date date3 = null;

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@Test
	public void findAllEmployeTest() throws ParseException{
		
		
		date1 = dateFormat.parse("01/01/2000"); 
		date2 = dateFormat.parse("01/01/2001");
		date3 = dateFormat.parse("01/01/2002");
		
	  Employe emp1 = new Employe("Monsieur", "bobo", "bolo", "bolo@yahoo.fr", "manager", date1, new Date(), 350000);
	  entityManager.persist(emp1);	  
	  Employe emp2 = new Employe("Madame", "bibi", "bili", "bili@yahoo.fr", "secretaire", date2, new Date(), 350000);
	  entityManager.persist(emp2);
	  Employe emp3 = new Employe("Monsieur", "boubou", "boulou", "boulou@yahoo.fr", "informaticien", date3, new Date(), 345000);
	  entityManager.persist(emp3);
	  
	  entityManager.flush();
	  
	  Iterable<Employe> employes = dao.findAll();
	  assertThat(employes).hasSize(3).contains(emp1, emp2, emp3);
	
	}
	@Test
	public void findEmployeByIdTest() throws ParseException{
		
		date1 = dateFormat.parse("01/01/2000"); 
		date2 = dateFormat.parse("01/01/2001");
		
		Employe emp1 = new Employe("Monsieur", "bobo", "bolo", "bolo@yahoo.fr", "manager", date1, new Date(), 350000);
	    entityManager.persist(emp1);	
	    Employe emp2 = new Employe("Madame", "bibi", "bili", "bili@yahoo.fr", "secretaire", date2, new Date(), 350000);
		entityManager.persist(emp2);
		Employe employe1 = dao.findById(emp1.getIdempl()).get();
		assertThat(employe1).isEqualTo(emp1);
		
		Employe  employe2 = dao.findById(emp2.getIdempl()).get();
		assertThat(employe2).isEqualTo(emp2);
		
	}
	
	public void findEmployeByMailTest() throws ParseException{
		
		date1 = dateFormat.parse("01/01/2000"); 
		date2 = dateFormat.parse("01/01/2001");
		Employe emp1 = new Employe("Monsieur", "bobo", "bolo", "bolo@yahoo.fr", "manager", date1, new Date(), 350000);
	    entityManager.persist(emp1);
	    Employe emp2 = new Employe("Madame", "bibi", "bili", "bili@yahoo.fr", "secretaire", date2, new Date(), 350000);
		entityManager.persist(emp2);
		
		Employe employe = dao.findById(emp1.getIdempl()).get();
		
		assertEquals("bobo", employe.getPrenemp());
		assertEquals("bolo", employe.getPrenemp());
		assertEquals("bolo@yahoo.fr", employe.getMail());
		
		
	}

}
