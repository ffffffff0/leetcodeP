package alg;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
//        输入：c[0]=1, c[1]=2, c[2]=5, k=12
//        输出：3
//        解释：12 = 5 + 5 + 2

    }

    /**
     * 零钱兑换 贪心
     *
     * @param coins  coin type array
     * @param target target number
     * @return get target coin type number
     */
    static int coinGreed(int[] coins, int target) {
        int rest = target;
        int count = 0;

        for (int coin : coins) {
            int currentCount = rest / coin;
            rest -= currentCount * coin;
            count += currentCount;

            if (rest == 0) {
                return count;
            }
        }
        return -1;
    }

    /**
     * 零钱兑换 贪心 + 回溯
     *
     * @param coins  零钱种类
     * @param target 目标值
     * @param index  索引
     * @return 最少得数量
     */
    static int coinOfValue(int[] coins, int target, int index) {
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }

        int currentValue = coins[index];
        int minCount = Integer.MAX_VALUE;
        int currentMaxCount = target / currentValue;

        for (int count = currentMaxCount; count >= 0; count--) {
            int restValue = target - count * currentValue;

            if (restValue == 0) {
                minCount = Math.min(minCount, count);
                break;
            }

            int restCount = coinOfValue(coins, restValue, index + 1);

            if (restCount == Integer.MAX_VALUE) {
                if (count == 0) {
                    break;
                }
                continue;
            }

            minCount = Math.min(minCount, restCount + count);
        }
        return minCount;
    }

    /**
     * 列出所有零钱的排列组合
     *
     * @param coins  零钱种类
     * @param target 目标值
     * @param index  索引
     * @return 最少得数量
     */
    static int coinOfLoop(int[] coins, int target, int index) {
        int minCount = Integer.MAX_VALUE;

        if (index == coins.length) {
            return Math.min(minCount, coinOfValue(coins, target, 0));
        }

        // 列出零钱数组的排列组合
        for (int i = index; i < coins.length; i++) {
            int temp = coins[index];
            coins[index] = coins[i];
            coins[i] = temp;

            minCount = Math.min(minCount, coinOfLoop(coins, target, index + 1));

            temp = coins[index];
            coins[index] = coins[i];
            coins[i] = temp;
        }

        return minCount;
    }

    static void getMinCoins(int[] coins, int target, List<Integer> currentCount, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(currentCount));
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            int currentValue = coins[i];
            if (currentValue > target) {
                continue;
            }

            List<Integer> newCounts = new ArrayList<>(currentCount);
            newCounts.set(i, newCounts.get(i) + 1);
            int rest = target - currentValue;

            getMinCoins(coins, rest, currentCount, combinations);
        }
    }
}
