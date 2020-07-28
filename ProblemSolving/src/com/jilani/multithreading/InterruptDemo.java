package com.jilani.multithreading;

class InterruptDemo {

	public static void main(String[] args) throws InterruptedException {

		ExecuteMe em = new ExecuteMe();
		Thread t = new Thread(em);
		t.start();
		t.join();
		
		System.out.println(" Main thread going to sleep for 5 seconds");

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t.interrupt();

		System.out.println(" Interrupting child thread after 5 seconds");

		/*
		 * try { t.join(); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		System.out.println(" Done");

	}

}

class ExecuteMe implements Runnable {

	public void run() {

		System.out.println(" Executing child thread");

		try {
			Thread.sleep(1000 * 1000);
		} catch (InterruptedException ie) {
			System.out.println(" Thread got interrupted");
		}

	}
}