
public class LambdaTest {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 클래스");
			}
		});
		thread1.start();
		
		Thread thread2 = new Thread(() -> System.out.println("람다식"));
		thread2.start();
	}
	
}
