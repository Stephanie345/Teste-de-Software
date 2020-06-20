package model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class LibTest{
		
		@Test
		public void test1(){
			App letra = new App();
			String test1 = "hello world!";
			String resultadoTest1 = letra.capitalLetter(test1);
			assertEquals("Hello World!", resultadoTest1);
		}

		@Test
		public void test2(){
			App letra = new App();
			String test2= "stephanie!";
			String resultadoTest2 = letra.capitalLetter(test2);
			assertEquals("Stephanie!", resultadoTest2);
		}

		
		
}