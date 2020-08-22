package Belajar_JavaDasar_44_Exception_RantaiMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrayData = {0,1,2,3};
        Scanner userInput = new Scanner(System.in);
        System.out.print("Data ke : ");
        int input = userInput.nextInt();

        System.out.println("\n===== Exception Biasa =====");
        try {
            System.out.printf("data array ke %d = %d\n",input,arrayData[input]);
        }catch (Exception e){
            System.err.println(e);
        }

        System.out.println("\n===== Exception Method =====");
        int data = ambilDataArray(arrayData,input);
        System.out.printf("data array ke %d = %d",input,data);

        System.out.println("\n===== Exception Throw by Method =====");
        int data2 = 0;
        try {
            data2 = ambilDataArray2(arrayData,input);
        }catch (Exception e){
            System.err.println(e);
        }
        System.out.printf("data array ke %d = %d",input,data2);

        System.out.println("\n==== Akhir Program ====");
    }
    private static int ambilDataArray2(int[] array,int index) throws Exception{
        int hasil = array[index];
        return hasil;
    }
    private static int ambilDataArray(int[] array,int index){
        int hasil = 0;
        try {
            hasil = array[index];
        }catch (Exception e){
            System.err.println(e);
        }
        return hasil;
    }
}
