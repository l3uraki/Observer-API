package site.buraki.observer.core.person;

import site.buraki.observer.common.exceptions.core.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Бизнес-модель локации в трёхмерном пространстве.
 *
 * <p><b>Инварианты</b>:
 *
 * <ol>
 *     <li>Название заполнено.</li>
 *     <li>Длина названия не больше 512 символов.</li>
 *     <li>Координаты в трёхмерном пространстве заполнены.</li>
 * </ol>
 *
 * <p>Валидный экземпляр:
 *
 * <pre>{@code
 *     Location someLocation = new Location(
 *         "Деревня \"Светлое\"",
 *         new Coordinates(
 *             280.56f,
 *             -359.06f,
 *             839.47f
 *         )
 *     );
 * }</pre>
 *
 * <p>Невалидный экземпляр:
 *
 * <pre>{@code
 *     Location someLocation = new Location(
 *         "=".repeat(256) + "Деревня \"Тёмное\"" + "=".repeat(256),
 *         null
 *     );
 * }</pre>
 *
 * @author Расим "Buraki" Эминов
 * @see Coordinates
 * @since 0.1.0
 */
public class Location implements Comparable<Location> {

    private final String name;
    private final Coordinates coordinates;

    /**
     * Конструктор бизнес-модели локации в трёхмерном пространстве.
     *
     * @author Расим "Buraki" Эминов
     * @param name Название.
     * @param coordinates Координаты в трёхмерном пространстве.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     локации в трёхмерном пространстве.
     * @see Coordinates
     * @since 0.1.0
     */
    public Location(String name, Coordinates coordinates) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(2);

        if (name == null) {
            brokenInvariants.add("Название заполнено");
        }
        else if (name.length() > 512) {
            brokenInvariants.add("Длина названия не больше 512 символов");
        }
        if (coordinates == null) {
            brokenInvariants.add("Координаты в трёхмерном пространстве заполнены");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели локации в трёхмерном пространстве",
                    brokenInvariants
                )
            );
        }

        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Location otherLocation = (Location) o;

        return name.equals(otherLocation.name) &&
               coordinates.equals(otherLocation.coordinates);
    }

    @Override
    public int compareTo(Location o) {
        return coordinates.compareTo(o.coordinates);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(\n" +
               ("name=\"" + name + "\",").indent(4) +
               ("coordinates=" + coordinates).indent(4) +
               ")";
    }
}
