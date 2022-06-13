

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode844 {
    public static void main(String[] args) {
        String S = "ab#c##", T = "ad#c#";
        Solution s = new Solution();
        System.out.println(s.backspaceCompare(S, T));
    }

    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            LinkedList tmp_T = new LinkedList();
            LinkedList tmp_S = new LinkedList();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '#') {
                    if (tmp_S.isEmpty()) continue;
                    else {
                        tmp_S.pop();
                    }
                } else {
                    tmp_S.push(S.charAt(i));
                }
            }
            for (int i = 0; i < T.length(); i++) {
                if (T.charAt(i) == '#') {
                    if (tmp_S.isEmpty()) continue;
                    else {
                        tmp_T.pop();
                    }
                } else {
                    tmp_T.push(S.charAt(i));
                }
            }

            Iterator iterator = tmp_S.iterator();
            while (iterator.hasNext()) {
                char a = (char) iterator.next();
                System.out.println(a);
            }
            System.out.println(S.isEmpty());
            if (tmp_S.isEmpty() && tmp_T.isEmpty()) return true;
            else if (tmp_S.equals(tmp_T)) return true;
            else return false;
        }
    }
}
