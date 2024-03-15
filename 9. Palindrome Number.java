class Solution {
    public boolean isPalindrome(int x) {
         if (x < 0 || (x % 10 == 0 && x != 0)) { 
             // Handle negative numbers and trailing zeros
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // Check for even-length and odd-length palindromes
        return x == reversed || x == reversed / 10;
    }
}
