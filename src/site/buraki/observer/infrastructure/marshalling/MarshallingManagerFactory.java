package site.buraki.observer.infrastructure.marshalling;

import site.buraki.observer.infrastructure.marshalling.json.JSONMarshallingManager;

/**
 * Фабрика менеджеров маршалинга.
 *
 * @author Расим "Buraki" Эминов
 * @see IMarshallingManager
 * @since 0.2.0
 */
public class MarshallingManagerFactory {

    public static <T> IMarshallingManager<T> getJSONMarshallingManager() {
        return new JSONMarshallingManager<>();
    }
}
