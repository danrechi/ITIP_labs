public class Main {
    public static void main(String[] args){
        Warehouse warehouse =  new Warehouse();
        Product product1 = new Product("Apple",155, 10);
        Product product2 = new Product("Orange", 132, 12);
        Product product3 = new Product("adasd", 122, 22);
        warehouse.insertProduct("J0D1",product1);
        warehouse.insertProduct("L0012",product2);
        warehouse.insertProduct("DAA22",product3);
        System.out.println(warehouse.size());
        System.out.println(warehouse.isEmpty());
        System.out.println(warehouse.findProduct("J0D1").getName());
        warehouse.removeProduct("J0D1");
        System.out.println(warehouse.findProduct("J0D1"));
        System.out.println(warehouse.size());
    }
}
