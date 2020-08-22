package Belajar_JavaDasar_11_Oprator_Komparasi;

public class Main {
    public static void main(String[] args) {
        //Operator Komparasi akan menghaslkan nilai boolean
        int a , b,c;
        a = 10;
        b = 10;
        c = 20;
        System.out.printf("%d == %d : %s\n",a,b,(a == b));
        System.out.printf("%d != %d : %s\n",a,b,(a != b));
        System.out.printf("%d <= %d : %s\n",a,c,(a <= c));
        System.out.printf("%d < %d : %s\n",a,b,(a < b));
        System.out.printf("%d >= %d : %s\n",b,c,(b >= c));
        System.out.printf("%d > %d : %s\n",a,b,(a > b));
        System.out.printf("%d >= %d : %s\n",b,a,(b >= a));
        boolean hasil = a > 11;
        System.out.printf("%d > %d : !%s\n",a,11,!hasil);
    }
}
