package atts;

import java.util.Random;

public class Ex9 {
    public static void main(String[] args) {
        Thread par = new Thread(() -> gerarNumeros(true));
        Thread impar = new Thread(() -> gerarNumeros(false));

        par.start();
        impar.start();
    }

    private static void gerarNumeros(boolean isPar) {
        Random rand = new Random();
        int quantidade = rand.nextInt(10) + 1; 
        for (int i = 0; i < quantidade; i++) {
            int numero = rand.nextInt(100);
            if ((isPar && numero % 2 == 0) || (!isPar && numero % 2 != 0)) {
                System.out.println((isPar ? "Par: " : "Impar: ") + numero);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}