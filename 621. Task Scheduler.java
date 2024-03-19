class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        
        Arrays.sort(taskCount);
        
        int maxFreq = taskCount[25] - 1;
        int maxIdleTime = maxFreq * n;
        
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            maxIdleTime -= Math.min(taskCount[i], maxFreq);
        }
        
        return maxIdleTime > 0 ? tasks.length + maxIdleTime : tasks.length;
    }
}
