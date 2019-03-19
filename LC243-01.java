// time: O（
// space: O(n)

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || word1 == "" || word2 == "") {
            return Integer.MAX_VALUE;
        }
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> index = new ArrayList<Integer>();
            if (!map.containsKey(words[i])) {
                index.add(i);
                map.put(words[i], index);
            }
            else {
                index = map.get(words[i]);
                index.add(i);
                map.put(words[i], index);
            }
        }
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return Integer.MAX_VALUE;
        }
        List<Integer> word1Index = map.get(word1);
        List<Integer> word2Index = map.get(word2);
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < word1Index.size(); i++) {
            for (int j = 0; j < word2Index.size(); j++) {
                shortestDistance = Math.min(shortestDistance, Math.abs(word1Index.get(i) - word2Index.get(j)));
            }
        }
        return shortestDistance;
    }
}
