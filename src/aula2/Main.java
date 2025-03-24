package aula2;

public class Main {

	public static void main(String[] args) {
		/* 
		AltaPrioridade a = new AltaPrioridade();
		BaixaPrioridade b = new BaixaPrioridade();
		System.out.println("Iniciando Threads");
		b.start();
		a.start();
		
		Thread.currentThread();
		Thread.yield();
		System.out.println("Main finalizado");
		*/
		int[] v = {1,2,3,4};
		CalcNotSync c1 = new CalcNotSync("T1", v);
		CalcNotSync c2 = new CalcNotSync("T2", v);
	}

}
