import java.util.List;
import java.util.stream.Collectors;

public class AggregateDataProcessor {

    // агрегация
    @DataProcessor
    public void aggregateData(List<String> data) {
        String aggregatedResult = data.stream().collect(Collectors.joining(", "));
        data.clear();//удаляем все исходные данные
        data.add(aggregatedResult);//добавляем новые данные
    }
}
