package entrega_testes_funcionais;
import java.util.Scanner;
public class Controle {
	public Scanner scanner;
	public Controle(){
		scanner = new Scanner(System.in);
	}
	public int dia() {
		int op = scanner.nextInt();
		return op;
	}
	public float valor() {
		float t = scanner.nextFloat();
		return t;
	}
	@Override
	protected void finalize() throws Throwable {
		scanner.close();
	}
}


