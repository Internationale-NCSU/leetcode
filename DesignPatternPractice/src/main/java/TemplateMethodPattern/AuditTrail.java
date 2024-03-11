package TemplateMethodPattern;

public class AuditTrail {

    /*awfe;laksjdf;alsd
     * 
     */
    // test test test
    // console.log("ID:", token.text, token.line, token.column);
    // console.log("ID:", token.text, token.line, token.column);
    // console.log("ID:", token.text, token.line, token.column);
    /**
     * 
     * @param a,b,c
     * @return 
     * @apiNote asdfasdf
     * @exception fawegfaqwergfaw
     */

    private class innerClassA{
        int a;
        int b;
        public int add(){
            return a+b;
        }
    }
    private class innerClassB{
        int c;
        int d;
        innerClassA a1;
        innerClassA a2;
        innerClassA a3;
    }
    public int test(){
        return 1;
    }


    /**
     * @param a
     * @return
     */
    public void record(int a) {
        // console.log("ID:", token.text, token.line, token.column);
        // console.log("ID:", token.text, token.line, token.column);
        // console.log("ID:", token.text, token.line, token.column);
        System.out.println("Audit Trail");
        test();
    }
}
