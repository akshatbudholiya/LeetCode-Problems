class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlandGroups = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int rowEnd = i;
                    int colEnd = j;

                    // Find the bottom right corner of the current farmland group
                    while (rowEnd < m && land[rowEnd][j] == 1) {
                        colEnd = j;
                        while (colEnd < n && land[rowEnd][colEnd] == 1) {
                            colEnd++;
                        }
                        rowEnd++;
                    }
                    rowEnd--;

                    // Add the coordinates of the current farmland group to the result
                    int[] groupCoordinates = {i, j, rowEnd, colEnd - 1};
                    farmlandGroups.add(groupCoordinates);

                    // Mark the current group as visited
                    for (int x = i; x <= rowEnd; x++) {
                        for (int y = j; y <= colEnd - 1; y++) {
                            land[x][y] = 0;
                        }
                    }
                }
            }
        }
        
        // Convert List<int[]> to int[][]
        int[][] result = new int[farmlandGroups.size()][4];
        for (int i = 0; i < farmlandGroups.size(); i++) {
            result[i] = farmlandGroups.get(i);
        }
        
        return result;
    }
}
