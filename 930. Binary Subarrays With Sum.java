class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] count = new int[nums.length + 1];
        int sum = 0;
        int result = 0;

        for (int num : nums) {
            count[sum]++;
            sum += num;
            if (sum >= goal)
                result += count[sum - goal];
        }

        return result;
    }
}
