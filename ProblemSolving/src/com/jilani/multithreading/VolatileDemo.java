package com.jilani.multithreading;

public class VolatileDemo {

	public static void main(String[] args) {

		MyObject obj = new MyObject();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				obj.print();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				obj.set();
			}
		});

		t1.start();
		t2.start();
	}

}

class MyObject {

	boolean flag = true;

	public void print() {

		while (flag) {
			System.out.println(" flag is true");
			/*
			 * try { Thread.sleep(100); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
	}

	public void set() {
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		flag = false;
	}

}
