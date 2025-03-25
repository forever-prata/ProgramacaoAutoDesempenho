package aula5;

public class WaitNotifyTest {

	public static void main(String[] args) {
		Message msg = new Message("provess it");
		
		Waiter waiter = new Waiter(msg);
		new Thread(waiter,"waiter").start();
		
		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1,"waiter1").start();
		
		Notifier notifier = new Notifier(msg);
		new Thread(notifier,"notifier").start();
		
		System.out.println("all threads started");

	}

}
