package site.buraki.observer.infrastructure.marshalling.json;

import site.buraki.observer.infrastructure.marshalling.IDeserializer;
import site.buraki.observer.infrastructure.marshalling.IMarshallingManager;
import site.buraki.observer.infrastructure.marshalling.ISerializer;

/**
 * Менеджер маршалинга языка разметки JSON.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип сериализуемого/десериализуемого объекта.
 * @see IMarshallingManager
 * @see Serializer
 * @see Deserializer
 * @since 0.3.0
 */
public class JSONMarshallingManager<T> implements IMarshallingManager<T> {

    private final ISerializer<T> serializer = new Serializer<>();
    private final IDeserializer<T> deserializer = new Deserializer<>();

    @Override
    public ISerializer<T> getSerializer() {
        return serializer;
    }

    @Override
    public IDeserializer<T> getDeserializer() {
        return deserializer;
    }
}
