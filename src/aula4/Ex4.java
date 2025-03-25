package aula4;

import java.util.Random;

public class Ex4 {
    public static void main(String[] args) {
        Random random = new Random();
        
        Thread contadorAlta = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Contador Alta: " + i);
                if (random.nextBoolean()) {
                    try {
                        System.out.println("Contador Alta pausado");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        contadorAlta.setPriority(Thread.MAX_PRIORITY);
        
        Thread contadorBaixa = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Contador Baixa: " + i);
                if (random.nextBoolean()) {
                    try {
                        System.out.println("Contador Baixa pausado");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        contadorBaixa.setPriority(Thread.MIN_PRIORITY);
        
        contadorAlta.start();
        contadorBaixa.start();
        
        try {
            contadorAlta.join();
            contadorBaixa.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main finalizado");
    }
}