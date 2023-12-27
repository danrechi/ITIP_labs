import java.util.List;
public class TransformDataProcessor {

    // трансформация, все заглавной
    @DataProcessor
    public void transformToUppercase(List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i).toUpperCase());
        }
    }
}
