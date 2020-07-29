package practiceset1;

public class PalindromeCheck {

	public static void main(String[] args) {

		String str ="abcdcba";
		
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome(str, 0, str.length()-1));
	}

	static boolean isPalindrome(String str, int i, int j ) {
		
		return i >= j ? true: str.charAt(i) == str.charAt(j) && isPalindrome(str, i+1, j-1);
	}
	
	
	static boolean isPalindrome(String str) {
		
		if ( str == null || str.length() <= 1 )
			return true;

		int i = 0;
		int j = str.length()-1;
		
		while ( i < j ) {
		
			if ( str.charAt(i) != str.charAt(j))
				return false;
			
			i++;
			j--;
		}
		
		return true;
	}
}
