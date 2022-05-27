public class leetcode2156 {
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int nthToP = 0;
        long[] map = new long[k];
        map[0] = 1;
        for (int i = 1; i < k; i++) {
            map[i] = map[i-1]*power%modulo;
        }
        for (int i = 0; i < s.length()-k+1; i++) {
            int index = 0;
            long hashCode = 0;
            for (int j = i; j < i+k; j++) {
                int tmp = s.charAt(j)-'a'+1;
                //BigInteger powerN = new BigInteger();
                hashCode = (hashCode+(s.charAt(j)-'a'+1)*map[index])%modulo;
                index++;
            }
            if(hashCode==hashValue){
                return s.substring(i,i+k);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        System.out.println(subStrHash("leetcode",7,20,2,0));
    }
}
