package banheiro;
public class Convidado implements Runnable {
    private final String nome;

    public Convidado(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(BanheiroFesta.random.nextInt(5000));
            
            BanheiroFesta.banheiroLock.lock();
            try {
                usarBanheiro();
            } finally {
                BanheiroFesta.banheiroLock.unlock();
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nome + " foi interrompido enquanto tentava usar o banheiro.");
        }
    }

    private void usarBanheiro() throws InterruptedException {
        System.out.println(nome + " entrou no banheiro");
        
        int atividade = BanheiroFesta.random.nextInt(2) + 1;
        
        if (atividade == 1) {
            System.out.println(nome + ": Iniciando atividade rápida");
            Thread.sleep(2000);
            System.out.println(nome + ": Terminando atividade rápida");
        } else {
            System.out.println(nome + ": Iniciando atividade demorada");
            Thread.sleep(5000);
            System.out.println(nome + ": Terminando atividade demorada");
        }
        
        System.out.println(nome + ": Dando descarga");
        Thread.sleep(1000);
        System.out.println(nome + ": Lavando as mãos");
        Thread.sleep(1000);
        System.out.println(nome + ": Secando as mãos");
        Thread.sleep(500);
        System.out.println(nome + " saiu do banheiro");
    }
}