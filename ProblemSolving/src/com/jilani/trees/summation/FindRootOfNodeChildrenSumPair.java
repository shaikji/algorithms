package com.jilani.trees.summation;

public class FindRootOfNodeChildrenSumPair {

	public static void main(String[] args) {

		int[] sum = {5,0,0,0,5,5};
		
		Pair[] pairs = new Pair[sum.length];
		for ( int i=0; i < sum.length; i++) {
			pairs[i] = new Pair(i+1, sum[i]);
		}
		
		int root = findRoot(pairs);
		System.out.println(" Root = " + root);
	}
	
	static int findRoot(Pair[] pairs) {
		
		int root = 0;
		for ( Pair p: pairs) {
			root += (p.node_id - p.children_sum );
		}
		
		return root;
	}

	static class Pair{
		int node_id;
		int children_sum;
		Pair(int id, int sum){
			this.node_id = id;
			this.children_sum = sum;
		}
	}
}
