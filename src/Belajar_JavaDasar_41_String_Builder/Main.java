package Belajar_JavaDasar_41_String_Builder;

public class Main {
    public static void main(String[] args) {
        StringBuilder strDefault = new StringBuilder();
        System.out.println("KapasitasDefault : " + strDefault.capacity());

        StringBuilder stringBuilder = new StringBuilder("Hallo");
        printData(stringBuilder);

        System.out.println("==== Append ====");
        stringBuilder.append(" Semuanya");
        printData(stringBuilder);

        System.out.println("-----------------");
        stringBuilder.append(" Kabar");
        printData(stringBuilder);

        System.out.println("==== Insert ====");
        stringBuilder.insert(14," Apa" );
        printData(stringBuilder);

        System.out.println("==== Delete ====");
        stringBuilder.delete(6,15);
        printData(stringBuilder);

        System.out.println("==== Rubah Karakter Berdasarkan Index ====");
        stringBuilder.setCharAt(0,'h');
        printData(stringBuilder);

        System.out.println("==== Replace ====");
        stringBuilder.replace(0,5,"Hai");
        printData(stringBuilder);

        System.out.println("==== Casting ke String ====");
        String Kalimat = stringBuilder.toString();
        System.out.println("Data \t\t: " + Kalimat);
        int addressString = System.identityHashCode(Kalimat);
        System.out.println("Address \t: " + Integer.toHexString(addressString));
    }

    public static void printData (StringBuilder dataBuilder){

        System.out.println("Data \t\t: " + dataBuilder);
        System.out.println("Panjang \t: " + dataBuilder.length());
        System.out.println("Kapasitas \t: " + dataBuilder.capacity());

        int addressBuilder = System.identityHashCode(dataBuilder);
        System.out.println("Address \t: " + Integer.toHexString(addressBuilder));

    }
}
