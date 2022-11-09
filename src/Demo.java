import org.junit.Test;

public class Demo {
    public static String collapseLine(String line){
        String result = "";
        boolean isStart = false;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)!=' '&& line.charAt(i)!='\t'){
                isStart = true;
            }
            if(!isStart){
                continue;
            }
            if(line.charAt(i)!=' '){
                result = result+ line.charAt(i);
            }else {
                while (i + 1 < line.length() && (line.charAt(i + 1) == ' '||line.charAt(i + 1) == '\t')) {
                    i++;
                }
                if (i + 1 >= line.length()) {
                    break;
                }
                result = result+' ';
            }
        }
        return result;
    }
    @Test
    public void test(){
        System.out.println(collapseLine("\t some    on this one  \t  as well   !!!!   "));
    }
}
