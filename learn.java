import java.util.ArrayList;

public class learn{
    public static void main(String args[]) {
        System.out.println("Hello, World");
        System.out.printf("1 + 2 = %d\n", add(1, 2));
        System.out.printf("3 - 2 = %d\n", sub(3, 2));
        System.out.printf("5 * 2 = %d\n", mul(5, 2));
        System.out.printf("5 / 2 = %d\n", div(5, 2));
        System.out.printf("3 is %s\n", evenOrOdd(3));
        System.out.printf("4 is %s\n", evenOrOdd(4));
        System.out.printf("is 3 prime : %b\n", isPrime(3));
        System.out.printf("is 4 prime : %b\n", isPrime(4));
        System.out.println(sieveOfEratosthenes(100));
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int sub(int a, int b){
        return a - b;
    }

    public static int mul(int a, int b){
        return a * b;
    }

    public static int div(int a, int b){
        return a / b;
    }

    public static String evenOrOdd(int num) {
        if (num % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }

    public static boolean isPrime(int num) {
        int end = (int)Math.ceil(Math.sqrt(num));
        for (int i = 2; i <= end; i++) {
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int num) {
        ArrayList<Boolean> boolArray = new ArrayList<Boolean>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < num; i++) {
            boolArray.add(true);
        }

        boolArray.set(0, false);

        for(int i = 1; i < num; i++){
            if (boolArray.get(i) == true) {
                for (int j = 2 * i + 1 ; j < num; j += (i + 1)){
                    boolArray.set(j, false);
                }

                res.add(i + 1);
            }
        }

        return res;
    }
}