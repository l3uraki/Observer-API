package site.buraki.observer.core.person;

/**
 * Перечисление цветов, используемых бизнес-моделью человека.
 *
 * @author Расим "Buraki" Эминов
 * @see Person
 * @since 0.1.0
 */
public enum Color {

    BLACK,
    BLUE,
    GREEN,
    ORANGE,
    RED,
    WHITE,
    YELLOW;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name();
    }
}
