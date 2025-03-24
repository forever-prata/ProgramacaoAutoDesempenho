package aula2;

public class BaixaPrioridade extends Thread{
	public void run() {
		setPriority(1);
		for (int y = 0; y < 10; y++) {
			System.out.println("Baixa prioridade...");
			try {
				sleep(100);
			} catch (Exception e) {
				System.exit(0);
			}
		}
	}
}
