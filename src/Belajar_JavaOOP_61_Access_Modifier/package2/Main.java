package Belajar_JavaOOP_61_Access_Modifier.package2;

import Belajar_JavaOOP_61_Access_Modifier.package1.KelasA;
import Belajar_JavaOOP_61_Access_Modifier.package2.KelasB;

public class Main {
    public static void main(String[] args) {
        KelasA kelasA = new KelasA();

        //Tidak Bisa Karena Access Modifier = Private
        //-------------------------------------------
        // System.out.println(kelasA.memberA);
        // System.out.println(kelasA.functionA());
        //===========================================

        //Bisa Karena Access Modifier = Public
        //-------------------------------------------
        System.out.println(kelasA.functionB());
        //===========================================

        //Tidak Bisa Karena Access Modifier = Default
            //hanya dapat diakses di package yang sama
        //-------------------------------------------
        // System.out.println(kelasA.memberB);
        //===========================================

        //Bisa Karena Access Modifier = Protected
            //hanya dapat diakses di package yang sama /
            // dengan inheritance nya di package yang beda
        //-------------------------------------------
        KelasB kelasB = new KelasB();
        kelasB.methodC();
    }
}
