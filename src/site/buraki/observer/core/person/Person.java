package site.buraki.observer.core.person;

import site.buraki.observer.common.exceptions.core.ValidationException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Бизнес-модель человека.
 *
 * <p><b>Инварианты</b>:
 *
 * <ol>
 *     <li>Уникальный идентификатор больше 0.</li>
 *     <li>Имя заполнено.</li>
 *     <li>Дата создания заполнена.</li>
 *     <li>Цвет волос заполнен.</li>
 *     <li>Цвет глаз заполнен.</li>
 *     <li>Рост больше 0.</li>
 *     <li>Вес больше 0.</li>
 *     <li>Локация в трёхмерном пространстве заполнена.</li>
 * </ol>
 *
 * <p>Валидный экземпляр:
 *
 * <pre>{@code
 *     Person somePerson = new Person(
 *         847,
 *         "Иван",
 *         LocalDateTime.now(),
 *         HairColor.BLACK,
 *         EyeColor.BLUE,
 *         196.46f,
 *         87.12f,
 *         new Location(
 *             "Посёлок \"Красное\"",
 *             new Coordinates(
 *                 -910.51f,
 *                 692.78f,
 *                 2842.49f
 *             )
 *         )
 *     );
 * }</pre>
 *
 * <p>Невалидный экземпляр:
 *
 * <pre>{@code
 *     Person somePerson = new Person(
 *         0,
 *         " ",
 *         null,
 *         null,
 *         null,
 *         -176.31f,
 *         -67.72f,
 *         null
 *     );
 * }</pre>
 *
 * @author Расим "Buraki" Эминов
 * @see HairColor
 * @see EyeColor
 * @see Location
 * @since 0.1.0
 */
public class Person implements Comparable<Person> {

    private final long id;
    private String name;
    private final LocalDateTime createdAt;
    private HairColor hairColor;
    private final EyeColor eyeColor;
    private float height;
    private float weight;
    private Location location;

    /**
     * Конструктор бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param id Уникальный идентификатор.
     * @param name Имя.
     * @param createdAt Дата создания.
     * @param hairColor Цвет волос.
     * @param eyeColor Цвет глаз.
     * @param height Рост.
     * @param weight Вес.
     * @param location Локация в трёхмерном пространстве.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     человека.
     * @see HairColor
     * @see EyeColor
     * @see Location
     * @since 0.1.0
     */
    public Person(
            long id,
            String name,
            LocalDateTime createdAt,
            HairColor hairColor,
            EyeColor eyeColor,
            float height,
            float weight,
            Location location
    ) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(8);

        if (id <= 0) {
            brokenInvariants.add("Уникальный идентификатор больше 0");
        }
        if (name == null || name.isBlank()) {
            brokenInvariants.add("Имя заполнено");
        }
        if (createdAt == null) {
            brokenInvariants.add("Дата создания заполнена");
        }
        if (hairColor == null) {
            brokenInvariants.add("Цвет волос заполнен");
        }
        if (eyeColor == null) {
            brokenInvariants.add("Цвет глаз заполнен");
        }
        if (height <= 0) {
            brokenInvariants.add("Рост больше 0");
        }
        if (weight <= 0) {
            brokenInvariants.add("Вес больше 0");
        }
        if (location == null) {
            brokenInvariants.add("Локация в трёхмерном пространстве заполнена");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели человека",
                    brokenInvariants
                )
            );
        }

        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.height = height;
        this.weight = weight;
        this.location = location;
    }

    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Изменение имени экземпляра бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param newName Новое имя.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     человека.
     * @since 0.1.0
     */
    public void rename(String newName) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(1);

        if (newName == null || newName.isBlank()) {
            brokenInvariants.add("Имя заполнено");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели человека",
                    brokenInvariants
                )
            );
        }

        name = newName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    /**
     * Изменение цвета волос экземпляра бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param newHairColor Новый цвет волос.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     человека.
     * @see HairColor
     * @since 0.1.0
     */
    public void recolorHair(HairColor newHairColor) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(1);

        if (newHairColor == null) {
            brokenInvariants.add("Цвет волос заполнен");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели человека",
                    brokenInvariants
                )
            );
        }

        hairColor = newHairColor;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public float getHeight() {
        return height;
    }

    /**
     * Увеличение роста экземпляра бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param delta Изменение роста.
     * @throws IllegalArgumentException Неположительное увеличение
     *     роста.
     * @since 0.1.0
     */
    public void growUp(float delta) {
        if (delta <= 0) {
            throw new IllegalArgumentException("Неположительное увеличение роста");
        }

        height += delta;
    }

    public float getWeight() {
        return weight;
    }

    /**
     * Увеличение веса экземпляра бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param delta Изменение веса.
     * @throws IllegalArgumentException Неположительное увеличение веса.
     * @since 0.1.0
     */
    public void gainWeight(float delta) {
        if (delta <= 0) {
            throw new IllegalArgumentException("Неположительное увеличение веса");
        }

        weight += delta;
    }

    /**
     * Уменьшение веса экземпляра бизнес-модели человека.
     *
     * @author Расим "Buraki" Эминов
     * @param delta Изменение веса.
     * @throws IllegalArgumentException Неотрицательное уменьшение веса.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     человека.
     * @since 0.1.0
     */
    public void loseWeight(float delta) throws ValidationException {
        if (delta >= 0) {
            throw new IllegalArgumentException("Неотрицательное уменьшение веса");
        }

        List<String> brokenInvariants = new ArrayList<>(1);

        if (weight < -delta) {
            brokenInvariants.add("Вес больше 0");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели человека",
                    brokenInvariants
                )
            );
        }

        weight -= delta;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Перемещение экземпляра бизнес-модели человека на новую локацию
     * в трёхмерном пространстве.
     *
     * @author Расим "Buraki" Эминов
     * @param newLocation Новая локация.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     человека.
     * @see Location
     * @since 0.1.0
     */
    public void goTo(Location newLocation) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(1);

        if (newLocation == null) {
            brokenInvariants.add("Локация в трёхмерном пространстве заполнена");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели человека",
                    brokenInvariants
                )
            );
        }

        location = newLocation;
    }

    @Override
    public int hashCode() {
        return (int) (id % Integer.MAX_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Person otherPerson = (Person) o;

        return id == otherPerson.id;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return getClass().getSimpleName() + "(\n" +
               ("id=" + id + ", ").indent(4) +
               ("name=" + name + ", ").indent(4) +
               ("createdAt=" + createdAt.format(dtFormat) + ", ").indent(4) +
               ("hairColor=" + hairColor + ", ").indent(4) +
               ("eyeColor=" + eyeColor + ", ").indent(4) +
               ("height=" + height + ", ").indent(4) +
               ("weight=" + weight + ", ").indent(4) +
               ("location=" + location + "\n").indent(4) +
               ")";
    }
}
