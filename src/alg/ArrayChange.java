package alg;

import java.util.Arrays;

public class ArrayChange {
    public static void main(String[] args) {
        int[] useArray = new int[]{1, 2, 3};
        coinChange(useArray, 0);
    }

    static void coinChange(int[] coins, int index) {
        if (index == coins.length) {
            System.out.println(Arrays.toString(coins));
        }

        for (int i = index; i < coins.length; i++) {
            int temp = coins[index];
            coins[index] = coins[i];
            coins[i] = temp;

            coinChange(coins, index + 1);

            temp = coins[index];
            coins[index] = coins[i];
            coins[i] = temp;
        }
    }
}
