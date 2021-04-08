package avs.brainterpreter.test.unit.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import avs.brainterpreter.engine.BrainCleaner;

public class CleaningTest {

	@Test
	public void test() {
		BrainCleaner brainParser = new BrainCleaner(stringToParse);
		String parsed = brainParser.cleanString();
		assertEquals(parsed, stringExpected);
	}
	
	public static final String stringExpected = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";

	public static final String stringToParse = "++++++++++          Affecte 10 à la case 0\r\n" + 
			"[                   Boucle initiale qui affecte des valeurs utiles au tableau \r\n" + 
			"   >                avance à la case 1 \r\n" + 
			"   +++++++          affecte 7 à la case 1\r\n" + 
			"   >                avance à la case 2\r\n" + 
			"   ++++++++++       affecte 10 à la case 2 \r\n" + 
			"   >                avance à la case 3\r\n" + 
			"   +++              affecte 3 à la case 3\r\n" + 
			"   >                avance à la case 4\r\n" + 
			"   +                affecte 1 à la case 4\r\n" + 
			"   <<<<             retourne à la case 0\r\n" + 
			"   -                enlève 1 à la case 0\r\n" + 
			"]                   jusqu'à ce que la case 0 soit = à 0\r\n" + 
			"la boucle initialise le tableau selon les valeurs suivantes:\r\n" + 
			"Case : Valeur\r\n" + 
			"0 : 0\r\n" + 
			"1 : 70\r\n" + 
			"2 : 100\r\n" + 
			"3 : 30\r\n" + 
			"4 : 10\r\n" + 
			"\r\n" + 
			">++                    ajoute 2 à la case 1 (70 plus 2 = 72)\r\n" + 
			".                      imprime le caractère 'H' (72)\r\n" + 
			">+                     ajoute 1 à la case 2 (100 plus 1 = 101)\r\n" + 
			".                      imprime le caractère 'e' (101)\r\n" + 
			"+++++++                ajoute 7 à la case 2 (101 plus 7 = 108)\r\n" + 
			".                      imprime le caractère 'l'  (108)\r\n" + 
			".                      imprime le caractère 'l'  (108)\r\n" + 
			"+++                    ajoute 3 à la case 2 (108 plus 3 = 111)\r\n" + 
			".                      imprime le caractère 'o' (111)\r\n" + 
			">++                    ajoute 2 à la case 3 (30 plus 2 = 32)\r\n" + 
			".                      imprime le caractère ' '(espace) (32)\r\n" + 
			"<<                     revient à la case 1\r\n" + 
			"+++++++++++++++        ajoute 15 à la case 1 (72 plus 15 = 87)\r\n" + 
			".                      imprime le caractère 'W' (87)\r\n" + 
			">                      repart à la case 2\r\n" + 
			".                      imprime le caractère 'o' (111)\r\n" + 
			"+++                    ajoute 3 à la case 2 (111 plus 3 = 114)\r\n" + 
			".                      imprime le caractère 'r' (114)\r\n" + 
			"------                 enlève 6 à la case 2 (114 moins 6 = 108)\r\n" + 
			".                      imprime le caractère 'l'  (108)\r\n" + 
			"--------               enlève 8 à la case 2 (108 moins 8 = 100)\r\n" + 
			".                      imprime le caractère 'd'  (100)\r\n" + 
			">                      repart à la case 3\r\n" + 
			"+                      ajoute 1 à la case 3 (32 plus 1 = 33)\r\n" + 
			".                      imprime le caractère '!' (33)\r\n" + 
			">                      va à la case 4\r\n" + 
			".                      imprime le caractère '\\n'(nouvelle ligne) (10)";
}
