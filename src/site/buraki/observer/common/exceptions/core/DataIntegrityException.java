package site.buraki.observer.common.exceptions.core;

/**
 * Нарушение целостности данных в хранилище.
 *
 * @author Расим "Buraki" Эминов
 * @since 0.1.0
 */
public class DataIntegrityException extends CoreLayerException {

    /**
     * Конструктор исключения.
     *
     * @author Расим "Buraki" Эминов
     * @since 0.1.0
     */
    public DataIntegrityException() {
        super();
    }

    /**
     * Конструктор исключения с детализированным сообщением, содержащим
     * описание нарушенного ограничения целостности данных в хранилище.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @since 0.1.0
     */
    public DataIntegrityException(String detailedMessage) {
        super(detailedMessage);
    }

    /**
     * Конструктор исключения с причинным исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param cause Причинное исключение/ошибка.
     * @since 0.1.0
     */
    public DataIntegrityException(Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор исключения с детализированным сообщением и
     * причинным исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @param cause Причинное исключение/ошибка.
     * @see DataIntegrityException#DataIntegrityException(String)
     * @see DataIntegrityException#DataIntegrityException(Throwable)
     * @since 0.1.0
     */
    public DataIntegrityException(String detailedMessage, Throwable cause) {
        super(detailedMessage, cause);
    }
}
