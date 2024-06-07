package site.buraki.observer.core.person;

/**
 * Перечисление цветов волос бизнес-модели человека.
 *
 * @author Расим "Buraki" Эминов
 * @see Person
 * @since 0.1.0
 */
public enum HairColor {

    WHITE,
    GINGER,
    BLACK;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name();
    }
}
