package site.buraki.observer.infrastructure.marshalling;

/**
 * Абстрактный менеджер маршалинга.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип сериализуемого/десериализуемого объекта.
 * @see ISerializer
 * @see IDeserializer
 * @since 0.2.0
 */
public interface IMarshallingManager<T> {

    ISerializer<T> getSerializer();

    IDeserializer<T> getDeserializer();
}
