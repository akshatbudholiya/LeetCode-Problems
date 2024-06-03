class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0; // pointer for s
        int j = 0; // pointer for t

        // Traverse both strings
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }

        // If j has not reached the end of t, return the number of remaining characters in t
        return n - j;
    }
}
