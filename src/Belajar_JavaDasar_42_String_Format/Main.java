package Belajar_JavaDasar_42_String_Format;

import java.util.Formatter;

public class Main {
    public static void main(String[] args) {
        String nama = "Latina";
        int umur = 10;

        //Output : Nama Saya Latina ,Umur saya 10
        System.out.println("Nama Saya " + nama + " Umur saya " + umur);

        System.out.println("==== Format String ====");
        System.out.printf("Nama Saya \"%s\" Umur Saya \"%d\"\n", nama,umur);
        System.out.printf("\"%d%%\" asli\n",umur);
        /*
         *  Conversion =
         *  f = Floating
         *  d = Integer
         *  c = Char
         *  s = String
         *  b = boolean
         */

        // Struktur Format = %conversion
            // %[argumentIndex][flags][width][.precision]conversion

        System.out.println(" === [argumentIndex] ===");
        System.out.printf("Hallo %1$s Apa Kabar ,%1$s lagi ngapain\n",nama);
        System.out.printf("umur %1$s sekarang %2$d \n",nama,umur);

        System.out.println(" === [flags] ===");
        int int1 = 5;
        int int2 = 8;
        int hasil = int1 - int2;
        System.out.printf("%d - %d = %+d\n",int1,int2,hasil);

        System.out.println(" === [width] ===");
        int int3 = 1000;
        System.out.println("INTEGER");
        System.out.printf("%d\n",int3);
        // flags == "%5d", artinya ambil slot/lebar 5 string
        System.out.printf("%5d\n",int3);
        System.out.println("-----------------");
        // flags == "-", artinya rata kiri
        // flags == "+", artinya rata kanan
        // flags == "+-", artinya rata kiri dengan + space diblakang
        System.out.printf("%-5d\n",int3);
        System.out.printf("%+6d\n",int3);
        System.out.printf("%+-6d\n",int3);
        System.out.printf("%+-6d\n",int3);

        // flags == "0", artinya Menambahkan leading '0' didepan
        System.out.printf("%010d\n",int3);
        System.out.printf("%+010d\n",int3);
        int int4 = 10000000;
        System.out.printf("-%,10d\n",int4);

        System.out.println("\n---- Floating Point ----");
        float float1 = 1.543f;
        //Floating Point akan mengambil width dengan 6 decimal
        System.out.printf("%f\n",float1);
        System.out.printf("%9f\n",float1);

        System.out.println(" === [.precision] ===");
        float float2 = 15.6782f;
        //Bulatkan bilangan 1,2,3,4 kebawah
        //Bulatkan bilangan 5,6,7,8,9 keatas
        System.out.printf("%f\n",float2);
        System.out.printf("%.1f\n",float2);
        System.out.printf("%+08.2f\n",float2);

        String nama2 = "Hatena";
        float IPK = 3.2311212112121f;
        System.out.printf(
                "%1$s: IPK %2$s berapa?? \n, %2$s: saya dapet %3$+5.2f", nama, nama2, IPK
        );

        System.out.println("\n\n--- Dengan save Format kedalam Variable ---");
        //Save Format kedalam variableString
        String info1 = "nama: " + nama2 + ", IPK = " + IPK;
        System.out.println(info1);
        String info2 = String.format("nama: %s, IPK = %2$+5.2f",nama2,IPK);
        System.out.println(info2);

        System.out.println("\n--- save Format kedalam Stringbuilder ---");
        StringBuilder builderInfo = new StringBuilder();
        Formatter formatterBuilder = new Formatter(builderInfo);

        formatterBuilder.format("nama: %s, IPK = %2$+5.2f",nama2,IPK);
        System.out.println(builderInfo);
    }
}
