import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode68 {
    /*
   Intuition: Break down the problem into right justified lines and left justified lines. The last line will be left justified while all other lines are right justified.
   The basic idea is to loop over all of the words while maintaining the number of letters we have in our to be added line, number of words, and the starting pointer to the
   first word we will add. When we reach a point that the current word we are looking at plus the letters we have chosen plus a space in between each word is too long to fit
   in our line (> maxWidth) we call our rightJustify method and add it to the resulting list. We can reset our values as we are emptying our line and move our pointer to our current
   index which will be the start of the next line. The last line is justified outside of the loop as we will have filled the line to some capacity at the time we exit.
   */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int prev = 0, numWords = 0, letters = 0, n = words.length;

        for (int i = 0; i < n; i++) {
            if (letters + words[i].length() + numWords > maxWidth) {
                res.add(rightJustify(words, maxWidth, letters, numWords, prev, i));
                numWords = letters = 0;
                prev = i;
            }

            numWords++;
            letters += words[i].length();
        }

        res.add(leftJustify(words, maxWidth - letters - (numWords - 1), prev, n));

        return res;
    }

    /*
    Given an array of strings, the number of trailing spaces, and the bounds for which words to be left justified,
    this function creates and returns a string of the words in the given range separated by a single space with trailing
    spaces through the maxWidth of the line. The trailingSpaces argument should be passed in according to the desired maxWidth.
    */
    public String leftJustify(String[] words, int trailingSpaces, int prev, int end) {
        StringBuilder cur = new StringBuilder();

        for (int j = prev; j < end; j++)
            cur.append(words[j]).append(' ');

        cur.deleteCharAt(cur.length() - 1);
        for (int j = 0; j < trailingSpaces; j++)
            cur.append(' ');

        return cur.toString();
    }

    /*
    Given an array of strings, the maxWidth of the line, the number of letters of all words, the number of words, and the range in the array of
    the words to be added, this function creates and returns a string of the words in the given range right justified such that the first and last words are
    at the start and end of the line with spaces evenly distributed between each word with remaining spaces distributed left to right. If there is only one word,
    the remaining spaces fill the space to the right through to the maxWidth.
    */
    public String rightJustify(String[] words, int maxWidth, int letters, int numWords, int prev, int end) {
        StringBuilder cur = new StringBuilder();
        int spaces = (numWords == 1) ? (maxWidth - letters) : (maxWidth - letters) / (numWords - 1), rem = (numWords == 1) ? 0 : (maxWidth - letters) % (numWords - 1);

        if (numWords == 1) {
            cur.append(words[prev]);
            for (int j = 0; j < spaces; j++)
                cur.append(' ');
        } else {
            for (int j = prev; j < end - 1; j++) {
                cur.append(words[j]);
                for (int k = 0; k < spaces; k++)
                    cur.append(' ');
                if (rem-- > 0) cur.append(' ');
            }
            cur.append(words[end - 1]);
        }

        return cur.toString();
    }
}
