package atts;

import java.util.Random;

public class Ex3 extends Thread {
    private int x, a, b;

    public Ex3(int x, int a, int b) {
        this.x = x;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            int numero = rand.nextInt(b - a + 1) + a;
            System.out.println("Número gerado: " + numero);
        }
    }

    public static void main(String[] args) {
        Ex3 thread = new Ex3(10, 1, 100);
        thread.start();
    }
}