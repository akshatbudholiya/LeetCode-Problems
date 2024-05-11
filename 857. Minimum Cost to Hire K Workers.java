class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ratio = new double[n][2]; // ratio[i][0]: ratio of wage to quality, ratio[i][1]: quality
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) wage[i] / quality[i];
            ratio[i][1] = quality[i];
        }
        Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;

        for (double[] r : ratio) {
            maxHeap.offer(r[1]);
            totalQuality += r[1];
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * r[0]);
            }
        }
        return minCost;
    }
}
