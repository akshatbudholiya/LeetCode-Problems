import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = row[i] == '1' ? heights[i] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < cols + 1; i++) {
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }
}
