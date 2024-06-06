class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
         if (hand.length % groupSize != 0) {
            return false;
        }
        
        // Using TreeMap to maintain sorted order of the cards
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCount.isEmpty()) {
            int first = cardCount.firstKey();
            
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!cardCount.containsKey(card)) {
                    return false;
                }
                
                int count = cardCount.get(card);
                if (count == 1) {
                    cardCount.remove(card);
                } else {
                    cardCount.put(card, count - 1);
                }
            }
        }
        
        return true;
    }
}
