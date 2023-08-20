import org.apache.poi.ss.formula.functions.T;

public class leetcode211_DesignAddAndSearchWordsDataStructure {
    class WordDictionary{
        TrieNode root;
        class TrieNode{
            TrieNode[] children;
            Boolean isTheEndOfTheWord;
            public TrieNode(){
                children = new TrieNode[26];
                isTheEndOfTheWord = false;
            }

        }
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for(int i = 0; i<word.length();i++){
                curr.children[word.charAt(i)-'a'] = new TrieNode();
            }
            curr.isTheEndOfTheWord = true;
        }
        public boolean searchOnTrie(String word, int index, TrieNode root){
            if(index==word.length()){
                return root.isTheEndOfTheWord;
            }
            if(word.charAt(index)=='.'){
                for (int i = 0; i < root.children.length; i++) {
                    return searchOnTrie(word, index++, root.children[i]);
                }
            }else {
                return searchOnTrie(word,index++,root.children[word.charAt(index)-'a']);
            }
            return false;
        }
        public boolean search(String word) {
            return searchOnTrie(word,0,root);
        }
    }

}
