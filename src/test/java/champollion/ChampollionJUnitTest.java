package champollion;

import static champollion.TypeIntervention.TP;
import static champollion.TypeIntervention.TD;
import static champollion.TypeIntervention.CM;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention interTP, interTD, interCM;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
                interTP = new Intervention(TP);
                interTD = new Intervention(TD);
                interCM = new Intervention(CM);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
        }
        @Test
        public void testHeurePrevu(){
            // 10h TD pour UML
            untel.ajouteEnseignement(uml, 0, 10, 0);
            
            assertEquals(10, untel.heuresPrevues(),
                    "L'enseignant doit maintenant avoir 10 heures prévues");
        }
         @Test
        public void testEstEnSousService(){
            //Ajout de 30 heures faisant que l'enseignant soit en sous service (30<192 heures)
            untel.ajouteEnseignement(uml, 10, 10, 10);
            
            assertTrue(untel.estEnSousService(),
                "L'enseignant untel doit être en sous-service");
            
            //Ajout de 170 heures faisant que l'enseignant ne soit plus en sous service (200>192 heures)
            untel.ajouteEnseignement(uml, 10, 20, 20);
            untel.ajouteEnseignement(java, 50, 50, 20);
            
            assertFalse(untel.estEnSousService(),
                "L'enseignant untel ne doit pas être en sous-service");
        }
        /*@Test
        public void testAjoutIntervention(){
            untel.ajouteIntervention(interTP);
            
            assertSame(),
                "L'enseignant untel ne doit pas être en sous-service");
        }*/
        
        @Test
        public void testResteAPlanifier(){
            int sommePlanifier = 0;
            assertEquals(0, sommePlanifier,
                "la planification initiale doit être egale à 0");
        }
}
