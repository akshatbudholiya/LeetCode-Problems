class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Ensure m <= n for easier indexing
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int start = 0;
        int end = m;
        
        while (start <= end) {
            int i = (start + end) / 2;
            int j = (m + n + 1) / 2 - i;
            
            // Handle edge cases
            if (i > 0 && j < n && nums1[i-1] > nums2[j]) {
                end = i - 1;
            } else if (i < m && j > 0 && nums1[i] < nums2[j-1]) {
                start = i + 1;
            } else {
                // Find the maximum of the left half
                int maxLeft = Math.max(i == 0 ? Integer.MIN_VALUE : nums1[i-1], 
                                       j == 0 ? Integer.MIN_VALUE : nums2[j-1]);
                
                // Find the minimum of the right half
                int minRight = Math.min(i == m ? Integer.MAX_VALUE : nums1[i], 
                                        j == n ? Integer.MAX_VALUE : nums2[j]);
                
                // Determine the median based on even or odd total length
                if ((m + n) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return maxLeft;
                }
            }
        }
        return 0.0; // Should not reach here
    }
}
