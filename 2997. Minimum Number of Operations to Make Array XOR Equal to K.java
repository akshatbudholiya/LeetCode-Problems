class Solution {
    public int minOperations(int[] nums, int k) {
       int totalXOR = 0;
        for (int num : nums) {
            totalXOR ^= num;
        }
        
        int xorDiff = totalXOR ^ k;
        
        // Count the number of set bits in xorDiff
        int count = 0;
        while (xorDiff > 0) {
            count += xorDiff & 1;
            xorDiff >>= 1;
        }
        
        return count; 
    }
}
