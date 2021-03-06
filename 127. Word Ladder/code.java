//Given two words (beginWord and endWord), and a dictionary's word list, 
//find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//Only one letter can be changed at a time.
//Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

//Note:
//
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.
//You may assume no duplicates in the word list.
//You may assume beginWord and endWord are non-empty and are not the same.

//Example 1:
//
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.

//Example 2:
//
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList){
            dict.add(word);
        }
            
        if (dict == null){
            return 0;
        }

        int length = 1;

        if (start.equals(end)){
            return length;
        }

        dict.add(start);

        Queue<String> queue = new LinkedList<>();
        Set<String> hashset = new HashSet<>();

        queue.offer(start);
        hashset.add(start);

        while (!queue.isEmpty()){
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWords : getNextWords(word, dict)) {
                    if (nextWords.equals(end)){
                        return length;
                    }

                    if (hashset.add(nextWords)){
                        queue.offer(nextWords);
                    }
                }
            }
        }

        return 0;        
    }
    
    
    private ArrayList<String> getNextWords(String word, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++){
                if (word.charAt(i) == c){
                    continue;
                }

                String nextWord = changeCharacter(word, i, c);
                if (dict.contains(nextWord)){
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }    
    
    private String changeCharacter(String word, int index, char character){
        char[] charArray = word.toCharArray();
        charArray[index] = character;
        String newWord = new String (charArray);
        return newWord;
    }
    
}


