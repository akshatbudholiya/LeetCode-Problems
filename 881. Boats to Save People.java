class Solution {
    public int numRescueBoats(int[] people, int limit) {
         Arrays.sort(people); // Sort the array to optimize the two-pointer approach
        int left = 0; // Pointer for the lightest person
        int right = people.length - 1; // Pointer for the heaviest person
        int boats = 0; // Count of boats needed
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // If the sum of weights of two people is within the limit, they can share a boat
                left++; // Move the pointer for the lighter person to the next person
                right--; // Move the pointer for the heavier person to the previous person
            } else {
                // If the sum exceeds the limit, the heavier person goes alone in the boat
                right--; // Move the pointer for the heavier person to the previous person
            }
            boats++; // Increment boats count after handling each pair or single person
        }
        
        return boats;
    }
}
