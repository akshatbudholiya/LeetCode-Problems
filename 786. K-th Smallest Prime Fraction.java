class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;

        while (left < right) {
            double mid = (left + right) / 2;
            double maxFraction = 0.0;
            int[] result = new int[]{0, 1};
            int count = 0, j = 1;

            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] >= arr[j] * mid) {
                    j++;
                }
                count += n - j;
                if (j < n && maxFraction < (double) arr[i] / arr[j]) {
                    maxFraction = (double) arr[i] / arr[j];
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }

            if (count == k) {
                return result;
            } else if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return new int[]{};
    }
}
