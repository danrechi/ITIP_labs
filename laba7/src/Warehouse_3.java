import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Warehouse_3 {

    static class Loader {
        private String name;
        private int weight;

        public Loader(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
        //загрузка товаров
        public CompletableFuture<Void> loadThings(int finalWeight) {
            return CompletableFuture.runAsync(() -> {
                while (weight < finalWeight) {
                    System.out.println(name + " переносит товар");
                    weight += 30;//вес товара
                    try {
                        Thread.sleep(500); //задержка для наглядности
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + " идет на другой склад, собрано " + weight + " kg");
            });
        }
    }

    public static void main(String[] args) {
        Loader loader1 = new Loader("Грузчик 1", 0);
        Loader loader2 = new Loader("Грузчик 2", 0);
        Loader loader3 = new Loader("Грузчик 3", 0);

        int finalWeight = 150; //вес, который нужно достичь

        CompletableFuture<Void> task1 = loader1.loadThings(finalWeight);
        CompletableFuture<Void> task2 = loader2.loadThings(finalWeight);
        CompletableFuture<Void> task3 = loader3.loadThings(finalWeight);

        try {
            // Ожидание завершения всех задач
            CompletableFuture.allOf(task1, task2, task3).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Все грузчики отправились на другой склад.");
    }
}
