package practiceset1;

public class KadenesAlgorithm {

	public static void main(String[] args) {

		int[] arr =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(" Max subarray sum  = " + kadens(arr, arr.length) );
		System.out.println(" Max subarray sum  = " + kadens2(arr, arr.length) );

		System.out.println();
		int[] arr2 =  {-2, -3, -4, -1, -5};
		System.out.println(" Max subarray sum  = " + kadens(arr2, arr2.length) );
		System.out.println(" Max subarray sum  = " + kadens2(arr2, arr2.length) );
		
		
	}
	
	static int kadens(int[] arr, int N) {
		
		if ( arr == null || N <=  0)
			throw new IllegalArgumentException();
		
		int max_ending_here = 0;
		int max_so_far = 0;
		
		for ( int i=0; i< N; i++) {
			max_ending_here += arr[i];
			
			if ( max_ending_here < 0 )
				max_ending_here = 0;
			
			else if ( max_so_far < max_ending_here )
				max_so_far = max_ending_here;
			
		}
		
		return max_so_far;
	}

	// To handle all negative numbers
	
	static int kadens2(int[] arr, int N) {
		
		if ( arr == null || N <=  0)
			throw new IllegalArgumentException();
		
		int max_ending_here = arr[0];
		int max_so_far = arr[0];
		
		for ( int i=1; i< N; i++) {
			int num = arr[i];
			max_ending_here = Math.max(num, num + max_ending_here);
			max_so_far = Math.max(max_so_far, max_ending_here );
		}
		
		return max_so_far;
	}

}
