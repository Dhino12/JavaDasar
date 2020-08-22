package Belajar_JavaOOP_69_WildCards;

public class MainHeroine {
    private String name;
    private double age;

    public MainHeroine(String name, double age){
        this.name = name;
        this.age = age;
        print();
    }

    public void print(){
        System.out.println("Nama: " + name + " umur " + age);
    }
}
