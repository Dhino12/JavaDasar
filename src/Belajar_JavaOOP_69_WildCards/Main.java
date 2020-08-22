package Belajar_JavaOOP_69_WildCards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("String 1");
        ls.add("String 2");

        print(ls); // Baris Ini Valid

        Collection<MainHeroine> cp = new ArrayList<>();
        cp.add(new MainHeroine("Asheley",18));
        cp.add(new MainHeroine("Tia",18));

        print(cp); // Baris Ini Valid
    }

    public static void print(Collection<?> collection){
        //Disini terjadi perubahan
        for (Object o : collection){
            System.out.println(o);
        }
    }

    //========== Generic Method ===============
    static <T> void arrayToCollection(T[] a ,Collection <T> c){
        for (T p: a){
            c.add(p); //baris ini valid
        }
    }
}
// supertype dari semua tipe Collection
    // Hal ini dikenal dengan nama wildcard type,
    // ditulis dengan syntax Collection<?> yang artinya collection of unknown.
//method print() menjadi bisa dipanggil dengan tipe
    // Collection yang berbeda atau reuseable.

//kita menggunakan wildcard sebagai parameternya agar dapat
    // bekerja dengan beragam tipe data
//Penggunaan wildcard juga dapat kita lakukan saat
    // menuliskan kode metode generic class yang tidak bergantung pada
    // tipe parameternya. Misalnya, List.size atau List.clear.
