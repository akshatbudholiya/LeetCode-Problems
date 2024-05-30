class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        // Create a prefix XOR array
        int[] prefixXOR = new int[n + 1];
        prefixXOR[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
        }
        
        // Iterate over each possible j
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                // If prefixXOR[j] == prefixXOR[k+1], it means arr[j..k] has a XOR sum of 0
                if (prefixXOR[j] == prefixXOR[k + 1]) {
                    // For each valid k, there are k - j possible i's such that 0 <= i < j <= k < n
                    count += (k - j);
                }
            }
        }
        
        return count;
    }
}
