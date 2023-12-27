import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// многопоточная обработка данных
public class DataManager {

    // список обработчиков
    private final List<Object> dataProcessors = new ArrayList<>();
    // список данных
    private List<String> data = new ArrayList<>();

    // регистрации обработчика данных
    public void registerDataProcessor(Object processor) {
        dataProcessors.add(processor);
    }

    // загрузка данных
    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }

    // Метод для обработки данных с использованием многопоточности и Stream API
    public void processData() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<CompletableFuture<Void>> futures = dataProcessors.stream()
                .flatMap(processor -> {
                    List<Method> annotatedMethods = getAnnotatedMethods(processor);
                    return annotatedMethods.stream()
                            .map(method -> CompletableFuture.runAsync(() -> invokeMethod(method, processor, data), executorService));
                })
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.get();

        executorService.shutdown();
    }

    // сохранение обработанных данных в новый источник
    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }

    // получаем массив методов, фильтрует так чтобы было методы только с аннотацией, каждый метод
    //в список
    private List<Method> getAnnotatedMethods(Object processor) {
        return Stream.of(processor.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(DataProcessor.class))
                .collect(Collectors.toList());
    }

    // класс для вызова метода, который выполняется data(из load data), processor из register
    private void invokeMethod(Method method, Object processor, List<String> data) {
        try {
            method.invoke(processor, data);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

