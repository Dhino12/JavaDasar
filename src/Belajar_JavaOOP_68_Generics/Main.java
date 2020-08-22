package Belajar_JavaOOP_68_Generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //List tanpa parameter
        List lo = new ArrayList();

        //// lo menampung object string
        lo.add("lo - String 1"); // ini tidak bisa dicast ke Heroine ERROR
        //// lo menampung object Heroine
        lo.add(new MainHeroine("Cizuru Ichinose" ,19));

        for (Object o : lo){
            //// perlu type-casting dari Object ke Planet
            MainHeroine p = (MainHeroine) o ;
            p.print();
        }


        //List dengan tanpa type-parameter Heroine
            //dengan ini maka lp akan dilindungi compile-time type safety
        List<MainHeroine> lp = new ArrayList<>();
        //// lo menampung object Heroine
        lp.add(new MainHeroine("Nakano Yotsuba",19));
        lp.add(new MainHeroine("Nakano Miku",19));

        //Baris ini compile-error, lp tidak mengizinkan object string
        // lp.add("lp - String 1");

        for (MainHeroine z : lp){
            z.print();
        }
    }
}

//Dari kode di atas tidak ada compile-error tetapi saat kita
    // jalankan akan terjadi runtime-error.
    // Sebabnya, dalam List lo ada objek yang tidak bisa di-cast ke Heroine.
