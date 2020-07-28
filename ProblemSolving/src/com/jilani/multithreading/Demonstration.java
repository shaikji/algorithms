package com.jilani.multithreading;

class Demonstration {
	public static void main(String args[]) {

		MyRunnable runnable = new MyRunnable();
		Thread t = new Thread(runnable);
		//t.setDaemon(true);
		t.start();

		/*
		 * try { t.join(); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		System.out.println(" Main thread done");
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" Hi Thread " + i );
		}

	}

}