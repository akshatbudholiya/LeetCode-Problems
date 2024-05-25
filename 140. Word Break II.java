class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
         // Convert wordDict to a set for O(1) lookups
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, wordDict, 0, memo);
    }

    private List<String> backtrack(String s, List<String> wordDict, int start, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<String> results = new ArrayList<>();
        if (start == s.length()) {
            results.add("");
            return results;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                List<String> remainingSentences = backtrack(s, wordDict, end, memo);
                for (String sentence : remainingSentences) {
                    if (sentence.isEmpty()) {
                        results.add(word);
                    } else {
                        results.add(word + " " + sentence);
                    }
                }
            }
        }

        memo.put(start, results);
        return results;
    }
}
