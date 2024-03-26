class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // Initialize prefix with the first string
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce prefix until it matches
                if (prefix.isEmpty()) return ""; // If prefix becomes empty, there's no common prefix
            }
        }
        return prefix;
    }
}
