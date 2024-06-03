package site.buraki.observer.common.exceptions;

/**
 * Нарушение бизнес-правил.
 *
 * @author Расим "Buraki" Эминов
 * @since 0.1.0
 */
public class CoreLayerException extends Exception {

    /**
     * Конструктор исключения.
     *
     * @author Расим "Buraki" Эминов
     * @since 0.1.0
     */
    public CoreLayerException() {
        super();
    }

    /**
     * Конструктор исключения с детализированным сообщением, содержащим
     * описания нарушенных бизнес-правил.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @since 0.1.0
     */
    public CoreLayerException(String detailedMessage) {
        super(detailedMessage);
    }

    /**
     * Конструктор исключения с родительским исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param cause Родительское исключение/ошибка.
     * @since 0.1.0
     */
    public CoreLayerException(Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор исключения с детализированным сообщением и
     * родительским исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @param cause Родительское исключение/ошибка.
     * @see CoreLayerException#CoreLayerException(String)
     * @see CoreLayerException#CoreLayerException(Throwable)
     * @since 0.1.0
     */
    public CoreLayerException(String detailedMessage, Throwable cause) {
        super(detailedMessage, cause);
    }
}
