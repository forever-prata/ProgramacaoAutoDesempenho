package aula1;

public class Imprimir1 implements Runnable{
	String str;
	public Imprimir1 (String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.print(str);
			Thread.currentThread();
			Thread.yield();
		}
	}

}
