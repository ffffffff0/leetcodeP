package alg;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib(11));
        System.out.println(fib(12));
        System.out.println(fib(13));
    }

    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
