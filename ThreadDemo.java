
public class ThreadDemo {

	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 300; i++) {
					System.out.printf("Thread A %d\n", i);
				}
			}
		});

		Thread b = new Thread(() -> {
			for (int i = 1; i <= 300; i++) {
				System.out.printf("Thread B %d\n", i);
			}
		});

		a.start();
		b.start();

		for (int i = 1; i <= 300; i++) {
			System.out.printf("Thread Main %d\n", i);
		}
	}
}

class Demo2 {

	static int x = 0;

	public static void main(String[] args) {
		Thread a = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				x++;
			}
			System.out.printf("Thread C %d\n", x);
		});

		Thread b = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				x++;
			}
			System.out.printf("Thread D %d\n", x);
		});

		a.start();
		b.start();
	}
}

class Demo3 {

	static int x = 0;

	static Object o = new Object(); // dummy object for monitor

	public static void main(String[] args) {
		Thread a = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				synchronized (o) {
					x++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.printf("Thread E %d\n", x);
		});

		Thread b = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				synchronized (o) {
					x++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.printf("Thread F %d\n", x);
		});

		a.start();
		b.start();

		// sometimes value less than 2000 prints second because thread was
		// interrupted somewhere in the middle of call to printf with arg less
		// than 2000
	}
}
