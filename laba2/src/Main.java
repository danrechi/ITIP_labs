public class Main {
    public static void main(String[] args){
        Smartphone smartphone1 = new Smartphone("Apple",
                "Iphone 11",900,6.1f);
        Smartphone smartphone2 = new Smartphone("Samsung",
                "Galaxy 3",600,7.1f);
        System.out.println(Smartphone.getCntSmartphone());
        System.out.println(smartphone1.getCompany());
        smartphone1.off();
    }
}
