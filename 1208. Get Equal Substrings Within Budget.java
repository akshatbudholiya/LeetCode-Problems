class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int currentCost = 0;
        int maxLength = 0;
        
        while (right < n) {
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));
            
            // If the cost exceeds maxCost, shrink the window from the left
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            
            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
}
