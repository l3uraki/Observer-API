package site.buraki.observer.core.person;

/**
 * Перечисление цветов глаз бизнес-модели человека.
 *
 * @author Расим "Buraki" Эминов
 * @see Person
 * @since 0.1.0
 */
public enum EyeColor {

    BLUE,
    BROWN,
    GREY,
    GREEN,
    YELLOW;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "." + name();
    }
}
