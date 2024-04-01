class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any leading or trailing spaces
        s = s.trim();
        
        int length = 0;
        int i = s.length() - 1;
        
        // Iterate from the end of the string to find the last word's length
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}
