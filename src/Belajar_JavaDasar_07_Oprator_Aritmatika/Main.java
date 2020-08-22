package Belajar_JavaDasar_07_Oprator_Aritmatika;

public class Main {
    public static void main(String[] args) {
        //Oprasi Aritmatika
            //1. Penjumlaham ==========
        int a = 1;
        int b = 4;
        float hasil;
        hasil = a + b;
        System.out.printf("Hasil %d + %d: %d \n" ,a,b,(int)hasil);

            //2. Pengurangan
        hasil = a - b;
        System.out.printf("Hasil %d - %d: %d \n" ,a,b,(int)hasil);

            //3. Pembagian
        hasil = a / (float)b;
        System.out.printf("Hasil %d / %d: %f \n" ,a,b,hasil);

            //4. Perkalian
        hasil = a * b;
        System.out.printf("Hasil %d * %d: %d \n" ,a,b,(int)hasil);

            //5. Modulus
        hasil = a % b;
        System.out.printf("Hasil %d %% %d: %d \n" ,a,b,(int)hasil);

        //5. Modulus
        int c = 2;
        hasil = (a + b) * c;
        System.out.printf("Hasil (%d + %d) * %d: %d \n" ,a,b,c,(int)hasil);

        hasil = a + (b * c);
        System.out.printf("Hasil %d + (%d * %d): %d \n" ,a,b,c,(int)hasil);

        hasil = a + (b / c);
        System.out.printf("Hasil %d + (%d / %d): %d \n" ,a,b,c,(int)hasil);

        hasil = a * b / c;
        System.out.printf("Hasil %d * %d / %d: %d \n" ,a,b,c,(int)hasil);

    }
}
