public class strTest {
    public static void main(String[] args) {
        String test1 = "abc:de fgh";
        String test2 = "abc:de- fgh";
        String[] split = test1.split(":");
        String[] split2 = test2.split(":");
        int x = 0,y = 0;
        for (int i = 0; i < split[1].length(); i++) {
            if(split[1].charAt(i)==' '){
                x = i;
                break;
            }
        }
        for (int i = 0; i < split2[1].length(); i++) {
            if(split2[1].charAt(i)==' '){
                y = i;
                break;
            }
        }
        String first = split[0],
                second = split[1].substring(0,x),
                third = split[1].substring(x+1);
        System.out.println("test1: "+first+"......"+second+"......"+third);

        first = split2[0];
        second = split2[1].substring(0,y);
        third = split2[1].substring(y+1);
        System.out.println("test2: "+first+"......"+second+"......"+third);
    }
}
