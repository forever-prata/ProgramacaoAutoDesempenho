package aula2;

public class AltaPrioridade extends Thread{
	public void run() {
		setPriority(10);
		for (int y = 0; y < 10; y++) {
			System.out.println("Alta prioridade...");
			try {
				sleep(100);
			} catch (Exception e) {
				System.exit(0);
			}
		}
	}
}
