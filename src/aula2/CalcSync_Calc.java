package aula2;

public class CalcSync_Calc {
	private int soma;
	public synchronized int somaVet(int[] vet) {
		soma = 0;
		for (int i = 0; i < vet.length; i++) {
			soma += vet[i];
			System.out.println(Thread.currentThread().getName()+" - somando " + vet[i] + " - total = " + soma);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return soma;
	}
}
