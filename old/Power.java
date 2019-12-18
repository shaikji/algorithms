package stacks;
class Power{

    static int power(int a, int b) {


        if ( b ==0 ){
            return 1;
        }

        int temp = (int) power( a, (int)(b/2));

        if ( b %2 == 0 ){
            return temp * temp;
        } else {
            return a * temp * temp;
        }
    }


    public static void main(String[] args) {
        int a = 2;
        int n = 5;

        
        int power = power(2, 10);
        System.out.println(" Power = " + power);
    }
}
