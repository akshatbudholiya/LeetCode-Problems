class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Create a frequency map for the available letters
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }

        // Use memoization to store already computed results
        Map<String, Integer> memo = new HashMap<>();

        return maxScore(words, letterCount, score, 0, memo);
    }

    private static int maxScore(String[] words, int[] letterCount, int[] score, int index, Map<String, Integer> memo) {
        // Base case: if all words have been considered
        if (index == words.length) {
            return 0;
        }

        // Create a key for memoization
        String key = index + "-" + toString(letterCount);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: Skip the current word
        int maxScore = maxScore(words, letterCount, score, index + 1, memo);

        // Option 2: Include the current word (if possible)
        String word = words[index];
        boolean canForm = true;
        int currentWordScore = 0;
        int[] tempCount = letterCount.clone();

        for (char c : word.toCharArray()) {
            if (tempCount[c - 'a'] == 0) {
                canForm = false;
                break;
            }
            tempCount[c - 'a']--;
            currentWordScore += score[c - 'a'];
        }

        if (canForm) {
            maxScore = Math.max(maxScore, currentWordScore + maxScore(words, tempCount, score, index + 1, memo));
        }

        memo.put(key, maxScore);
        return maxScore;
    }

    private static String toString(int[] letterCount) {
        StringBuilder sb = new StringBuilder();
        for (int count : letterCount) {
            sb.append(count).append(',');
        }
        return sb.toString();
    }
}
