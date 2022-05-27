public class AmazonOA_Q1 {
    public static int addminCharacter(String searchWord,String resultWord){
        int sPoint = 0,rPoint = 0;
        while(sPoint<searchWord.length()){
            if(searchWord.charAt(sPoint)==resultWord.charAt(rPoint)){
                rPoint++;
            }
            sPoint++;
        }
        return resultWord.length()-rPoint;
    }

    public static void main(String[] args) {
        System.out.println(addminCharacter("arefgmaze","amazon"));
    }
}
