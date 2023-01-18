package QE;

import java.util.Arrays;

public class QuadraticEquation {
    private static int a;
    private static int b;
    private static int c;

    public QuadraticEquation(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void calculation(){
        equation();
        double disc = b*b-4*a*c;
        if (disc<0){
            System.out.println("Рівняння не має коренів");
            System.exit(0);
        }
        if (disc == 0){
            System.out.println("disc == 0" + findOneRoot());
        }
        Arrays.stream(findTwoRoots(disc)).forEach(System.out::println);
    }
    private static double findOneRoot(){
        return (b*-1)/(2*a);
    }
    private static double[] findTwoRoots(double disc){
        double[] roots = new double[2];
        int val = 1;
        for (int i = 0; i < roots.length; i++){
            roots[i] = (b*-1 + Math.sqrt(disc) * val);
            val -= 2;
        }
        return roots;
    }
    private static void checkEquation(){
        double x = 0;
        double x1 = 0;
        double x2 = 0;

        if (a == 0){
            System.out.println("Exception");
            System.exit(0);
        }

        if (b == 0){
            double val = (c* - 1)/a;
            if (val > 0){

            }
        }

        if (c == 0) {
            x1 = 0;
            x2 = (b * -1) / a;
        }
        if (b == 0 && c == 0){
            x = 0;
        }
    }

    private  static void equation(){
        String equetion = "";
        if (a == 1 || a == -1){
            equetion += (a == 1) ? "x2" : "-x2";
        } else {
            equetion += a + "x2";
        }
        if (b == 1 || b == -1) {
            equetion += (b == 1) ? "+x" : "-x";
        } else {
            equetion += (b >= 0) ? "+" + b + "x" : b + "x";
        }

        equetion += (c >= 0) ? "+" + c + "=0" : c + "=0";

        System.out.println(equetion);
    }
}
