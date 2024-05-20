class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Iterate over all possible subsets
        for (int i = 0; i < (1 << n); i++) { // There are 2^n possible subsets
            int subsetXOR = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Check if the j-th element is in the subset
                    subsetXOR ^= nums[j];
                }
            }
            sum += subsetXOR;
        }
        
        return sum;
    }
}
