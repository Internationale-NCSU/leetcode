import java.math.BigInteger;
import java.util.Scanner;

public class countInversion {
    public static void main(String[] args) {
        int arr[] = new int[100000];
        String seq = "";
        System.out.println("请输入数组：");
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while(sc.hasNextLine()){
            String s = sc.next();
            if(s.equals("-1")){
                break;
            }
            arr[index] = Integer.valueOf(s);
            index++;
            seq = seq.concat(s);
        }
        for (int i : arr) {
            System.out.println(i);
        }
        BigInteger count = new BigInteger("0");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                   count=count.add(new BigInteger("1"));
                }
            }
        }
        System.out.println(count);

    }
}
