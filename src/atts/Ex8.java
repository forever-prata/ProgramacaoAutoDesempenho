package atts;

import java.util.Random;

public class Ex8 extends Thread {
    private int x;

    public Ex8(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
        	String placa = gerarPlaca(rand);
            System.out.println("Placa gerada: " + placa);
        }
    }
    
    private String gerarPlaca(Random rand) {
        StringBuilder placa = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            placa.append((char) (rand.nextInt(26) + 'A'));
        }
        placa.append(rand.nextInt(10));
        placa.append((char) (rand.nextInt(26) + 'A'));
        placa.append(rand.nextInt(10));
        placa.append(rand.nextInt(10));
        return placa.toString();
    }

    public static void main(String[] args) {
        Ex8 thread = new Ex8(10);
        thread.start();
    }
}