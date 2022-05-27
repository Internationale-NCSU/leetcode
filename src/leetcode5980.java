import java.util.LinkedList;
import java.util.List;

public class leetcode5980 {
    public static String[] divideString(String s, int k, char fill) {
        int len;
        if(s.length()%k==0){
            len = s.length()/k;
        }else {
            len = s.length()/k+1;
        }
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len*k; i++) {
            if(i<s.length()){
                sb.append(s.charAt(i));
            }else {
                sb.append(fill);
            }
            if(sb.length()==k){
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        divideString("abcdefg",3,'x');
    }
}
