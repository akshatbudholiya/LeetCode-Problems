class Solution {
        private static final int MOD = 1000000007;

    public int checkRecord(int n) {
       // dp[i][j][k] => length i, j 'A's, ends with k consecutive 'L's
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1; // Base case: one way to have an empty sequence

        for (int i = 1; i <= n; i++) {
            // Ending with 'P'
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // Ending with 'L'
            for (int j = 0; j < 2; j++) {
                dp[i][j][1] = dp[i - 1][j][0] % MOD;
                dp[i][j][2] = dp[i - 1][j][1] % MOD;
            }
            // Ending with 'A'
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
        }

        long result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }
        return (int) result;
    }
}
