package aula1;

public class MinhaThread2 implements Runnable{
	@Override
	public void run() {
		for (int x = 0; x < 5; x++) {
			System.out.print("T1 | ");
			Thread.currentThread();
			Thread.yield();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
