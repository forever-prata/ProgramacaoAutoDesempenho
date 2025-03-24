package atts;

import java.util.Random;

public class Ex10 {
    public static void main(String[] args) {
        Medico medico1 = new Medico("Dr. João");
        Medico medico2 = new Medico("Dra. Maria");

        medico1.start();
        medico2.start();
    }
}

class Medico extends Thread {
    private String nome;

    public Medico(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 1; i <= 5; i++) {
            int tempoAtendimento = rand.nextInt(5000) + 1000;
            System.out.println(nome + " está atendendo o paciente " + i);
            try {
                Thread.sleep(tempoAtendimento);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nome + " terminou de atender o paciente " + i);
        }
    }
}