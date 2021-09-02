package org.mairie.comores;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mairie.comores.metier.MacClasse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionMairieComoresApplicationTests extends TestCase{



	@Test   
	public void testCalculer() throws Exception {
	    assertEquals(2,MacClasse.calculer(1,1));
	  }

}
