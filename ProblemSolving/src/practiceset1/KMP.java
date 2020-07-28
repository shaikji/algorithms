package practiceset1;

public class KMP {

	public static void main(String[] args) {

		String str = "ababcabcabababd";
		String substr = "ababd";
		System.out.println(kmp(str, substr));

		
		System.out.println();
		str ="abcxabcdabcdabcy";
		substr ="abcdabcy";
		System.out.println(kmp(str, substr));
		
	}
	
	static boolean kmp(String str, String substr) {
		
		int M = substr.length();
		int N = str.length();
		
		int[] pattern = buildPattern(substr);
		
		for ( int i: pattern)
			System.out.print(i + " , ");
		System.out.println();
		
		
		// Now do the comparison
		
		int i = 0;
		int j = 0;
		
		while ( i < N && j < M ) {
			
			if ( str.charAt(i) == substr.charAt(j)) {
				i++;
				j++;
			} else {
			
				if ( j != 0 )
					j = pattern[j-1];
				else
					i++;
			}
			
		}
		
		if ( j == M) {
			System.out.println(" Pattern found at index = " +  (i-j));
			return true;

		}
		return false;
	}
	
	
	static int[] buildPattern(String substr) {
		
		int[] pattern = new int[substr.length()];
		
		int i=0;
		int j = i+1;
		
		while ( j < pattern.length) {
			
			if ( substr.charAt(j) == substr.charAt(i)) {
				pattern[j] = i+1;
				i++;
				j++;
			} else {
				
				if ( i == 0 ) {
					pattern[j] = 0;
					j++;
				} else {
					i = pattern[i-1];
				}
			}
		}
		
		return pattern;
	}
	
}
