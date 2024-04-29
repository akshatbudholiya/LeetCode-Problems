class Solution {
    public boolean isMatch(String s, String p) {
         
         int m = s.length(), 
             n = p.length();
         boolean[][] dp = new boolean[m + 1][n + 1];

         // Base cases: empty string and pattern
         dp[0][0] = true;
         for (int i = 1; i <= n; i++) {
             if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2]; // Empty string matches '*' only when preceding char matches 0 times
              }
             }

         // Recursively building up solutions for substrings
         for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                 } 
                 else if (p.charAt(j - 1) == '*') {
                     if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                          dp[i][j] = dp[i][j - 2]; // '*' matches 0 occurrences of preceding char
                         } 
                         else {
                         // '*' matches 1 or more occurrences of preceding char
                          dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
    }
