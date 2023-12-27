public class Warehouse extends HashTable<String, Product> {
    public Warehouse() {
        super();
    }

    public void insertProduct(String barcode, Product product) {
        put(barcode, product);
    }

    public Product findProduct(String barcode) {
        return get(barcode);
    }

    public void removeProduct(String barcode) {
        remove(barcode);
    }
}
