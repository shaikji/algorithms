package com.jilani.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GetMinMultipleOfBinaryDigit {

	public static void main(String[] args) {

		int N = 12;

		System.out.println(" Get Min Multiple = " + getMinMultipleBinaryNumber(N));

	}

	static String getMinMultipleBinaryNumber(int N) {

		Queue<String> q = new LinkedList();
		Set<Integer> set = new HashSet();

		q.add("1");

		while (!q.isEmpty()) {

			String t = q.poll();
			int rem = mod(t, N);

			if (rem == 0)
				return t;

			if (!set.contains(rem)) {
				q.add(t + "0");
				q.add(t + "1");
			}

		}

		return "1";
	}

	static int mod(String t, int N) {

		int r = 0;

		for (int i = 0; i < t.length(); i++) {

			r = r * 10 + (t.charAt(i) - '0');
			r = r % N;
		}

		return r;
	}

}
