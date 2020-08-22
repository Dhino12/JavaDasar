package Belajar_JavaOOP_61_Access_Modifier.package2;

import Belajar_JavaOOP_61_Access_Modifier.package1.KelasA;

public class KelasB extends KelasA {

    @Override
    protected void methodC(){
        super.methodC();

        System.out.println(
                "Contoh pemanggilan methodC dari KelasA \ndiluar Package"
        );
    }
}
