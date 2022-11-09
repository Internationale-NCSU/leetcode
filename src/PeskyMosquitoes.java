import java.util.Scanner;

public class PeskyMosquitoes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTrapping = sc.nextInt();
        for (int i = 0; i < numberOfTrapping; i++) {
            int numberOfMosquito = sc.nextInt();
            double diameter = sc.nextDouble();
            double[][] positions = new double[numberOfMosquito][2];
            for (int j = 0; j < numberOfMosquito; j++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                positions[j][0] = x;
                positions[j][1] = y;
            }
            if(positions.length==1){
                System.out.println(1);
            }
            for (int j = 1; j < positions.length; j++) {
                for (int k = 0; k < j; k++) {
                    double xa = positions[j][0];
                    double ya = positions[j][1];
                    double xb = positions[k][0];
                    double yb = positions[k][1];
                }

            }
        }
    }
    double calLength(double xa,double ya, double xb,double yb){
        return Math.sqrt(Math.pow(xa-xb,2)+Math.pow(ya-yb,2));
    }
//    double[][] calOrigins(double xa, double ya, double xb, double yb, double diameters){
//        double midX = (xa+xb)/2;
//        double midY = (ya+yb)/2;
//        double a = calLength(xa,ya,0,0);
//        double halfOfAB = calLength(xa,ya,xb,yb)/2;
//        double height = diameters*diameters - Math.pow(calLength(xa,ya,midX,midY),2);
//        double[] vectorMO1 = vectorFindVertical(xa,xb,ya,yb)[0];
//        double[] vectorMO2 = vectorFindVertical(xa,xb,ya,yb)[1];
//    }
//    double[] vectorAdd(double xa,double ya, double xb,double yb){
//
//    }
    double vectorDotProduct(double xa,double ya, double xb,double yb){
        return ( xa * xb + ya * yb );
    }
    double[][] vectorFindVertical(double xa,double ya, double xb,double yb){
        double[][] vectors = new double[2][];
        vectors[0][0] = ya - yb;
        vectors[0][1] = xb - xa;
        vectors[1][0] = yb - ya;
        vectors[1][1] = xa - xb;
        return  vectors;
    }
}
