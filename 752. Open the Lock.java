class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        String start = "0000";
        if (deadendSet.contains(start))
            return -1;
        
        queue.offer(start);
        visited.add(start);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target))
                    return level;
                
                List<String> nextCombinations = getNextCombinations(current);
                for (String next : nextCombinations) {
                    if (!visited.contains(next) && !deadendSet.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            level++;
        }
        
        return -1; // Target not reachable
    }
    
    private List<String> getNextCombinations(String current) {
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] currentArray = current.toCharArray();
            char original = currentArray[i];
            currentArray[i] = (char) ((currentArray[i] - '0' + 1) % 10 + '0');
            combinations.add(new String(currentArray));
            currentArray[i] = (char) ((original - '0' + 9) % 10 + '0');
            combinations.add(new String(currentArray));
        }
        return combinations;
    }
}
