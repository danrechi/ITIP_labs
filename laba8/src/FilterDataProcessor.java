import java.util.List;

public class FilterDataProcessor {

    // удаляет если строка apple
    @DataProcessor
    public void filterOutApples(List<String> data) {
        data.removeIf(fruit -> fruit.equalsIgnoreCase("apple"));
    }
}
