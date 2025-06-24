package neetcode.DP2.java;

public class triangle {
    public int minimumTotal(int[][] triangle) {
        int m = triangle.length;
        int n = triangle[m-1].length;
        int[][] dp = new int[m][n];

        // init last row of dp
        System.arraycopy(triangle[m-1], 0, dp[m-1], 0, n);

        for (int i=m-2; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                dp[i][j] = triangle[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    } 
}
