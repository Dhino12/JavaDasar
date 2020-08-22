package Belajar_JavaDasar_09_Oprator_Unary;

public class Main {

    public static void main(String[] args) {
        // unary = operasi yang dilakukan pada satu variable
        int angka = 12;
        System.out.printf("Unary - %d = %d\n", angka , -angka);
        System.out.printf("Unary + %d = %d\n", angka , +angka);

        //Unary Decrement & Increment
        System.out.printf("Unary -- %d = %d [prefix] \n", angka , --angka);
        System.out.printf("Unary ++ %d = %d [prefix] \n", angka , ++angka);
        System.out.printf("Unary %d ++ = %d [postfix] \n", angka , angka++);
        System.out.printf("Unary %d -- = %d [postfix] \n", angka , angka--);
        System.out.printf("Unary %d menjadi %d\n", angka , angka);

        //Unary Boolean
        boolean hai = true;
        System.out.println("Unary Boolean = " + hai);
        System.out.println("Unary Boolean = " + !hai);
    }
}
