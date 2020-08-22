package Belajar_JavaDasar_57_Modifier_Access;

public class Lain {

    //Bagian ini hanya bisa diakses oleh Class ini saja
    private static void methodPrivate(){
        System.out.println("Private");
    }

    //Bagian ini bisa diakses oleh semua Class
    public static void methodPublic(){
        System.out.println("public");
        // methodPrivate();
    }

    //Hanya dapat diakses oleh Class di Package yang sama
    static void methodDefault(){
        System.out.println("default");
    }

    //Hanya dapat diakses oleh Class di Package yang sama
        //dan Subclassnua
    protected static void methodProtected(){
        System.out.println("protected");
    }
}
