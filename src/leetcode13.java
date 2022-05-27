import java.util.HashMap;
import java.util.Map;

public class leetcode13 {
    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s.length()==1){
            return map.get(s.charAt(0));
        }
        int integer = 0;
        int front = 0;
        int rear = front+1;
        while(front<s.length()){
            if(rear>=s.length()){
                integer+=map.get(s.charAt(front));
                break;
            }
            if(map.get(s.charAt(rear))<=map.get(s.charAt(front))){
                integer+=map.get(s.charAt(front));
                front++;
                rear++;
                continue;
            }else {
                integer+=map.get(s.charAt(rear))-map.get(s.charAt(front));
                front = front+2;
                rear = rear+2;
            }
        }
        return integer;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XIII"));
    }
}
