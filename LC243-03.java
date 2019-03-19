// time: O(n)
// space: O(1)
// one pass

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || word1 == "" || word2 == "") {
            return Integer.MAX_VALUE;
        }
        int word1Index = -1;
        int word2Index = -1;
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            }
            else if (words[i].equals(word2)) {
                word2Index = i;
            }
            if (word1Index >= 0 && word2Index >= 0) {
                shortestDistance = Math.min(shortestDistance, Math.abs(word1Index - word2Index));
            }
        }
        return shortestDistance;
    }
}
