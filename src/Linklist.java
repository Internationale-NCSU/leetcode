import java.awt.image.BufferedImage;
import java.io.*;
import java.text.Normalizer;
import java.util.Scanner;

public class Linklist {
    public static void main(String[] args) throws IOException {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        Singlelinklist singlelinklist = new Singlelinklist();

        FileInputStream fileInputStream = new FileInputStream("D:\\JavaTestFile\\SuiTangHeroRank.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileReader fileReader = new FileReader("D:\\JavaTestFile\\SuiTangHeroRank.txt");
        int n = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (n != -1) {
            n = fileReader.read();
            char c = (char) n;
            stringBuffer.append(c);
        }
        System.out.println(stringBuffer);
        /*
        while(loop){
            System.out.println("Please input the hero's rank,name and ");
            int no = scanner.nextInt();
            if(no==-1) break;
            String name = scanner.next();
            ListNode listNode = new ListNode(no,name,null);
            singlelinklist.add(listNode);
        }*/
        singlelinklist.print();

    }
}

class Singlelinklist {
    private ListNode head = new ListNode(0, "", null);

    public void add(ListNode listNode) {

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = listNode;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println("No:" + temp.no + " name:" + temp.name);
            temp = temp.next;
        }
    }

}

class ListNode {
    public int no;
    public String name;
    public ListNode next;

    public ListNode(int no, String name, ListNode next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }
}
