import java.util.Arrays;
import java.util.Collection;

public class leetcode165 {
    public static int compareVersion(String version1, String version2) {
        String[] splitV1 = version1.split("\\.");
        String[] splitV2 = version2.split("\\.");
        int len = Math.min(splitV1.length,splitV2.length);
        int value1,value2;
        for (int i = 0; i < Math.max(splitV1.length,splitV2.length); i++) {
            value1 = i < splitV1.length ? Integer.valueOf(splitV1[i]) : 0;
            value2 = i < splitV2.length ? Integer.valueOf(splitV2[i]) : 0;
            if(value1!=value2){
                return value1 > value2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01","1.001"));
    }
}
