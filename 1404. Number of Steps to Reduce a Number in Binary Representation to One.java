class Solution {
    public int numSteps(String s) {

        int steps = 0;
        int carry = 0;
        int length = s.length();

        // Start from the least significant bit (rightmost bit) and move to the most significant bit (leftmost bit)
        for (int i = length - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            if (bit + carry == 1) { // When the current bit (with carry) is 1 (odd)
                carry = 1; // Adding 1 makes it even for the next step
                steps += 2; // One step to add 1, another step to divide by 2
            } else { // When the current bit (with carry) is 0 (even)
                steps += 1; // Just one step to divide by 2
            }
        }

        // For the most significant bit
        steps += carry;
        
        return steps;
    }
}
