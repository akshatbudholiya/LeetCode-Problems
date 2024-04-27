class Solution {
    public int findRotateSteps(String ring, String key) {
         int n = ring.length();
        int m = key.length();

        // Create a HashMap to store the indices of each character in the ring
        Map<Character, List<Integer>> charIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            if (!charIndices.containsKey(c)) {
                charIndices.put(c, new ArrayList<>());
            }
            charIndices.get(c).add(i);
        }

        // Dynamic programming table to store the minimum steps
        int[][] dp = new int[m][n];

        // Initialize the dynamic programming table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(ring, key, 0, 0, charIndices, dp);
    }

    private int dfs(String ring, String key, int ringIndex, int keyIndex, Map<Character, List<Integer>> charIndices, int[][] dp) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (dp[keyIndex][ringIndex] != -1) {
            return dp[keyIndex][ringIndex];
        }

        char targetChar = key.charAt(keyIndex);
        List<Integer> indices = charIndices.get(targetChar);
        int minSteps = Integer.MAX_VALUE;

        for (int nextRingIndex : indices) {
            int stepsToMove = Math.min(Math.abs(nextRingIndex - ringIndex), ring.length() - Math.abs(nextRingIndex - ringIndex));
            int stepsToType = 1; // Pressing the center button
            int totalSteps = stepsToMove + stepsToType + dfs(ring, key, nextRingIndex, keyIndex + 1, charIndices, dp);
            minSteps = Math.min(minSteps, totalSteps);
        }

        dp[keyIndex][ringIndex] = minSteps;
        return minSteps;
    }
}
