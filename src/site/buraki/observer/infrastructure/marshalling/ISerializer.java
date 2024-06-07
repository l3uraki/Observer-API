package site.buraki.observer.infrastructure.marshalling;

import java.io.OutputStream;
import java.util.List;

/**
 * Абстрактный сериализатор.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип сериализуемого объекта.
 * @see IMarshallingManager
 * @since 0.2.0
 */
public interface ISerializer<T> {

    void serializeOne(T object, OutputStream outputStream);

    void serializeMany(List<T> objects, OutputStream outputStream);
}
