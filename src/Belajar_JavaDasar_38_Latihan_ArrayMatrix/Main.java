package Belajar_JavaDasar_38_Latihan_ArrayMatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrixA = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] matrixB = {
                {11,12,13},
                {14,15,16},
                {17,18,19}
        };
        printArray(matrixA);
        System.out.println("\t+");
        printArray(matrixB);

        System.out.println("\t=");
        int[][] hasilTambah = tambah(matrixA,matrixB);
        printArray(hasilTambah);

        System.out.println("\nPerkalian Matrix");

        int[][] matrixC = {
                {1,2},
                {3,4},
        };
        int[][] matrixD = {
                {11,12},
                {13,14},
        };

        int[][] hasilKali = kali(matrixC,matrixD);
        printArray(hasilKali);
    }

    public static int[][] kali(int[][] Matrix1, int[][] Matrix2){
        int barisC = Matrix1.length;
        int kolomC = Matrix1[0].length;
        int barisD = Matrix2.length;
        int kolomD = Matrix2[0].length;
        int buffer = 0;

        int[][] hasil = new int[barisC][kolomD];
        //Jika MatrixA * MatrixB maka jumlah baris akan mengikuti matrixA,
        //Kolom akan mengikuti kolomB
        for (int i = 0 ; i < barisC; i++){
            for (int j = 0 ; j < kolomD; j++){
                buffer = 0;
                for (int k = 0; k < kolomC; k++){
                    buffer += Matrix1[i][k] * Matrix2[k][j];
                }
                hasil[i][j] = buffer;
            }
        }
        return hasil;
    }

    public static int[][] tambah(int[][] Matrix1,int[][] Matrix2){
        int barisA = Matrix1.length;
        int kolomA = Matrix1[0].length;
        int barisB = Matrix2.length;
        int kolomB = Matrix2[0].length;
        int[][] hasil = new int[barisA][kolomA];

        if(barisA == barisA && kolomA == kolomB){
            for (int i = 0 ; i < barisA ; i++){
                for (int j = 0 ; j < kolomA; j++){
                    hasil[i][j] = Matrix1[i][j] + Matrix2[i][j];
                }
            }
        }else {
            System.out.println("Jumlah Baris dan Kolom Tidak sama");
        }
        return hasil;
    }

    public static void printArray(int[][] dataArray){
        int baris = dataArray.length;
        int kolom = dataArray[0].length;

        for (int i = 0; i < baris; i++){
            System.out.print("[");
            for (int j = 0 ; j < kolom ; j++){
                System.out.print(dataArray[i][j]);
                if(j < kolom - 1){
                    System.out.print(",");
                }else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }
    }
}
