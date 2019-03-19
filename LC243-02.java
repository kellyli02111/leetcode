// 

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || word1 == "" || word2 == "") {
            return Integer.MAX_VALUE;
        }
        List<Integer> word1Index = new ArrayList<Integer>();
        List<Integer> word2Index = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index.add(i);
            }
            else if (words[i].equals(word2)) {
                word2Index.add(i);
            }
        }
        if (word1Index.size() == 0 || word2Index.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < word1Index.size(); i++) {
            for (int j = 0; j < word2Index.size(); j++) {
                shortestDistance = Math.min(shortestDistance, Math.abs(word1Index.get(i) - word2Index.get(j)));
            }
        }
        return shortestDistance;
    }
}
