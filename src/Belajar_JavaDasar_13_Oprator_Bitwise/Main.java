package Belajar_JavaDasar_13_Oprator_Bitwise;

public class Main {
    public static void main(String[] args) {
        // Operator Bitwise --> Operator Melakukan Operasi pada Bit
        byte a = 1;
        byte b,c;
        String a_bits,b_bits,c_bits;

        a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("%s = %d \n",a_bits ,a);

        //Operator Shift Left
        System.out.println("===== ShifLeft ( << )");
        b = (byte) (a << 1);
        b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);

        //Operator Shift Right
        System.out.println("===== ShifRight ( >> )");
        b = (byte) (b >> 1);
        b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);

        //Operator OR
        System.out.println("===== OR ( | )");
        a = 22;
        a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("%s = %d \n",a_bits ,a);
        b = 12;
        b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);
        System.out.println("----- OR -----");
        c = (byte)(a | b);
        c_bits = String.format("%8s",Integer.toBinaryString(c)).replace(' ','0');
        System.out.printf("%s = %d \n",c_bits ,c);

        //Operator AND
        System.out.println("===== AND ( & )");
        a = 22;
        a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("%s = %d \n",a_bits ,a);
        b = 12;
        b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);
        System.out.println("----- AND -----");
        c = (byte)(a & b);
        c_bits = String.format("%8s",Integer.toBinaryString(c)).replace(' ','0');
        System.out.printf("%s = %d \n",c_bits ,c);

        //Operator XOR
        System.out.println("===== XOR ( ^ )");
        a = 22;
        a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("%s = %d \n",a_bits ,a);
        b = 12;
        b_bits = String.format("%8s",Integer.toBinaryString(b)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);
        System.out.println("----- XOR -----");
        c = (byte)(a ^ b);
        c_bits = String.format("%8s",Integer.toBinaryString(c)).replace(' ','0');
        System.out.printf("%s = %d \n",c_bits ,c);

        //Operator NOT
        System.out.println("===== NOT ( ~ )");
        a = 22;
        b = (byte) ~a;
        a_bits = String.format("%8s",Integer.toBinaryString(a)).replace(' ','0');
        System.out.printf("%s = %d \n",a_bits ,a);
        System.out.println("----- NOT -----");
        b_bits = String.format("%8s",Integer.toBinaryString(b).substring(24)).replace(' ','0');
        System.out.printf("%s = %d \n",b_bits ,b);
    }
}
