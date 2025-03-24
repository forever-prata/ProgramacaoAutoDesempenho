package atts;

public class Ex11 {
    public static void main(String[] args) {
        System.out.println("Foi iniciada a construção do Carro");

        Thread motor = new Thread(() -> construirParte("Motor"));
        Thread roda = new Thread(() -> construirParte("Rodas"));
        Thread carroceria = new Thread(() -> construirParte("Carroceria"));

        motor.start();
        roda.start();
        carroceria.start();

        try {
            motor.join();
            roda.join();
            carroceria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A construção do carro foi finalizada");
    }

    private static void construirParte(String parte) {
        System.out.println("Construindo " + parte);
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(parte + " finalizada");
    }
}