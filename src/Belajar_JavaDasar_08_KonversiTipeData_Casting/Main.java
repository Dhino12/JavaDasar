package Belajar_JavaDasar_08_KonversiTipeData_Casting;

public class Main {
    public static void main(String[] args) {
        int a = 450; // 32 bit
        System.out.println("nilai a: " + a);

        // Int To Long
            //dengan tipe data max kecil dari Int
        long b =  a;
        System.out.println("Nilai b: " + b);
        System.out.println("Long Max: " + Long.MAX_VALUE);

        // Int To Byte
            //dengan tipe data max kecil dari Int
        byte c = (byte) a;
        System.out.println("Nilai b: " + c);
        System.out.println("Byte Max: " + Byte.MAX_VALUE + "\n");

        int d = 10;
        int e = 4;
        float l = (float) d / e;
        System.out.printf("%d / %d : %f",d,e,l);

    }
}
