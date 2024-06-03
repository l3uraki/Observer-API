package site.buraki.observer.common.exceptions.core;

import java.util.StringJoiner;

/**
 * Нарушение инвариантов бизнес-модели.
 *
 * @author Расим "Buraki" Эминов
 * @since 0.1.0
 */
public class ValidationException extends CoreLayerException {

    /**
     * Конструктор исключения.
     *
     * @author Расим "Buraki" Эминов
     * @since 0.1.0
     */
    public ValidationException() {
        super();
    }

    /**
     * Конструктор исключения с детализированным сообщением, содержащим
     * описания нарушенных инвариантов бизнес-модели.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @see ValidationException#createDetailedMessage(String, Iterable)
     * @since 0.1.0
     */
    public ValidationException(String detailedMessage) {
        super(detailedMessage);
    }

    /**
     * Конструктор исключения с родительским исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param cause Родительское исключение/ошибка.
     * @since 0.1.0
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * Конструктор исключения с детализированным сообщением и
     * родительским исключением/ошибкой.
     *
     * @author Расим "Buraki" Эминов
     * @param detailedMessage Детализированное сообщение.
     * @param cause Родительское исключение/ошибка.
     * @see ValidationException#ValidationException(String)
     * @see ValidationException#ValidationException(Throwable)
     * @since 0.1.0
     */
    public ValidationException(String detailedMessage, Throwable cause) {
        super(detailedMessage, cause);
    }

    /**
     * Создание детализированного сообщения, содержащего описания
     * нарушенных инвариантов бизнес-модели.
     *
     * @author Расим "Buraki" Эминов
     * @param mainMessage Главное сообщение.
     * @param brokenInvariants Описания нарушенных инвариантов
     *     бизнес-модели.
     * @return Детализированное сообщение.
     * @see ValidationException#ValidationException(String)
     * @see ValidationException#ValidationException(String, Throwable)
     * @since 0.1.0
     */
    public static String createDetailedMessage(
            String mainMessage,
            Iterable<String> brokenInvariants
    ) {
        StringJoiner invariantsDisplay = new StringJoiner("\n");

        int counter = 0;
        for (String invariant : brokenInvariants) {
            invariantsDisplay.add(++counter + ") " + invariant);
        }

        return mainMessage + "\n" + invariantsDisplay;
    }
}
