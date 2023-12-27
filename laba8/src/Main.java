import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        // создаем объект DataManager
        DataManager dataManager = new DataManager();

        // рега обработчиков данных
        dataManager.registerDataProcessor(new FilterDataProcessor());
        dataManager.registerDataProcessor(new TransformDataProcessor());
        dataManager.registerDataProcessor(new AggregateDataProcessor());

        try {
            // загрузка данных из исходного источника
            dataManager.loadData("D:/JavaPr/laba8/src/123.txt");

            // обработка данные с использованием многопоточности и Stream API
            dataManager.processData();

            // обработанные данные в новый источник
            dataManager.saveData("./output.txt");
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
