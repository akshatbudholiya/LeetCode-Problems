class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }
    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            // Include the element at index i
            current.add(nums[i]);
            // Move to the next element
            generateSubsets(i + 1, nums, current, result);
            // Exclude the element at index i (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
