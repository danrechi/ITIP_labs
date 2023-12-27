import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация, используемая для пометки методов обработки данных
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface DataProcessor {
}
