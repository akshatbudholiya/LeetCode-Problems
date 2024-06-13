class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
         // Sort the seats and students arrays
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        
        // Calculate the total number of moves required
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        
        return moves;
    }
}
