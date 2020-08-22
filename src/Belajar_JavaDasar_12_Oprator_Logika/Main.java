package Belajar_JavaDasar_12_Oprator_Logika;

public class Main {
    public static void main(String[] args) {
        // Operator Logika --> Opeerasi yang digunakan pada boolean
            // || , && , !

        //==========================================
            // karena menggunakan operator '==' yang artinya membandingkan alamat
            // di memori bukan nilainya
        String s1 = "geeksquiz";
        String s2 = "geeksquiz";
        System.out.println("s1 == s2 is:" + s1 == s2);
        //============================================

        boolean a ,b ,c;
        a = true;
        b = true;
        System.out.println("\n===== OR ( || ) =====");
        c = a || b;
        System.out.println(a + " || " + b + " = " +  c);
        a = false;
        c = a || b;
        System.out.println(a + " || " + b + " = " +  c);
        a = true;
        b = false;
        c = a || b;
        System.out.println(a + " || " + b + " = " +  c);
        a = false;
        b = false;
        c = a || b;
        System.out.println(a + " || " + b + " = " +  c + "\n");

        System.out.println("===== AND ( && ) =====");
        a = true;
        b = true;
        c = a && b;
        System.out.println(a + " && " + b + " = " +  c);
        a = false;
        b = true;
        c = a && b;
        System.out.println(a + " && " + b + " = " +  c);
        a = true;
        b = false;
        c = a && b;
        System.out.println(a + " && " + b + " = " +  c);
        a = false;
        b = false;
        c = a && b;
        System.out.println(a + " && " + b + " = " +  c + "\n");

        System.out.println("===== XOR ( ^ ) =====");
        a = true;
        b = true;
        c = a ^ b;
        System.out.println(a + " ^ " + b + " = " +  c);
        a = false;
        b = true;
        c = a ^ b;
        System.out.println(a + " ^ " + b + " = " +  c);
        a = true;
        b = false;
        c = a ^ b;
        System.out.println(a + " ^ " + b + " = " +  c);
        a = false;
        b = false;
        c = a ^ b;
        System.out.println(a + " ^ " + b + " = " +  c + "\n");

        System.out.println("===== NOT ( ! ) =====");
        a = true;
        System.out.println("!" + a + " = " + !a);
        a = false;
        System.out.println("!" + a + " = " + !a);
    }
}
