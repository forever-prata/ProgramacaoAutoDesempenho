package aula1;

public class MinhaThread3 implements Runnable{
	@Override
	public void run() {
		for (int x = 0; x < 5; x++) {
			System.out.print("T2 | ");
			Thread.currentThread();
			Thread.yield();
		}
	}
}
