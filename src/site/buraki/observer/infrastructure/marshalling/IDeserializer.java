package site.buraki.observer.infrastructure.marshalling;

import java.io.InputStream;
import java.util.List;

/**
 * Абстрактный десериализатор.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип десериализуемого объекта.
 * @since 0.2.0
 */
public interface IDeserializer<T> {

    T deserializeOne(Class<T> objectType, InputStream inputStream);

    List<T> deserializeMany(Class<T> objectsType, InputStream inputStream);
}
