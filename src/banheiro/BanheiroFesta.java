package banheiro;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BanheiroFesta {
    public static final Lock banheiroLock = new ReentrantLock();
    public static final Random random = new Random();

    public static void main(String[] args) {
        Thread[] convidados = {
            new Thread(new Convidado("João")),
            new Thread(new Convidado("Maria")),
            new Thread(new Convidado("Pedro")),
            new Thread(new Convidado("Ana")),
            new Thread(new Convidado("Carlos"))
        };

        for (Thread convidado : convidados) {
            convidado.start();
        }
    }
}