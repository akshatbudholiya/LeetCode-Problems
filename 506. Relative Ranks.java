class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        // Populate TreeMap with scores and indices
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        // Assign ranks
        String[] result = new String[score.length];
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }

        return result;
    }
}
