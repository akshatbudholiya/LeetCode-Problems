class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // Check for the case where all elements are greater than or equal to n
        if (nums[0] >= n) {
            return n;
        }

        // Iterate through the sorted array
        for (int i = 1; i <= n; i++) {
            if (nums[n - i] >= i && (n - i - 1 < 0 || nums[n - i - 1] < i)) {
                return i;
            }
        }

        // If no valid x is found
        return -1; 
    }
}
