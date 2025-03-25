package aula4;

import java.util.Random;

public class Ex5 {
    private static volatile boolean ligada = false;
    private static volatile int temperatura = 0;
    private static final int TEMPERATURA_MAXIMA = 1600;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Thread ligar = new Thread(() -> {
            while (true) {
                if (!ligada) {
                    System.out.println("Ligando caldeira...");
                    ligada = true;
                    temperatura = 500;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ligar.setPriority(Thread.MIN_PRIORITY);

        Thread alimentar = new Thread(() -> {
            while (true) {
                if (ligada) {
                    System.out.println("Alimentando caldeira...");
                    temperatura += random.nextInt(300);
                    System.out.println("Temperatura atual: " + temperatura);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        alimentar.setPriority(Thread.MIN_PRIORITY);

        Thread limpar = new Thread(() -> {
            while (true) {
                if (!ligada) {
                    System.out.println("Limpando caldeira...");
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        limpar.setPriority(Thread.MIN_PRIORITY);

        Thread desligar = new Thread(() -> {
            while (true) {
                if (ligada && temperatura > TEMPERATURA_MAXIMA) {
                    System.out.println("Temperatura crítica! Desligando caldeira...");
                    ligada = false;
                    while (temperatura > 100) {
                        temperatura -= 100;
                        System.out.println("Resfriando... Temperatura: " + temperatura);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        desligar.setPriority(Thread.MAX_PRIORITY);

        ligar.start();
        alimentar.start();
        limpar.start();
        desligar.start();
    }
}
