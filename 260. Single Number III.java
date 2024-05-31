class Solution {
    public int[] singleNumber(int[] nums) {
        
         int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find any set bit in the xor result
        int setBit = xor & -xor; // This isolates the rightmost set bit
        
        // Step 3: Partition the numbers into two groups and find the unique numbers
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & setBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}
