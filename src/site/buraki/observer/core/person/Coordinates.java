package site.buraki.observer.core.person;

import site.buraki.observer.common.exceptions.core.ValidationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Бизнес-модель координат в трёхмерном пространстве.
 *
 * <p><b>Инварианты</b>:
 *
 * <ol>
 *     <li>Значение абсциссы не меньше -16384.</li>
 *     <li>Значение абсциссы не больше 16384.</li>
 *     <li>Значение ординаты не меньше -1024.</li>
 *     <li>Значение ординаты не больше 1024.</li>
 *     <li>Значение аппликаты не меньше -16384.</li>
 *     <li>Значение аппликаты не больше 16384.</li>
 * </ol>
 *
 * <p>Валидный экземпляр:
 *
 * <pre>{@code
 *     Coordinates someCoordinates = new Coordinates(
 *         2031.81f,
 *         1002.65f,
 *         511.61f
 *     );
 * }</pre>
 *
 * <p>Невалидный экземпляр:
 *
 * <pre>{@code
 *     Coordinates someCoordinates = new Coordinates(
 *         -66068.84f,
 *         -9512.35f,
 *         -90799.91f
 *     );
 * }</pre>
 *
 * @author Расим "Buraki" Эминов
 * @since 0.1.0
 */
public class Coordinates implements Comparable<Coordinates> {

    private final float x;
    private final float y;
    private final float z;

    /**
     * Конструктор бизнес-модели координат в трёхмерном пространстве.
     *
     * @author Расим "Buraki" Эминов
     * @param x Значение абсциссы.
     * @param y Значение ординаты.
     * @param z Значение аппликаты.
     * @throws ValidationException Нарушены инварианты бизнес-модели
     *     координат в трёхмерном пространстве.
     * @since 0.1.0
     */
    public Coordinates(float x, float y, float z) throws ValidationException {
        List<String> brokenInvariants = new ArrayList<>(3);

        if (x < -16384) {
            brokenInvariants.add("Значение абсциссы не меньше -16384");
        }
        if (x > 16384) {
            brokenInvariants.add("Значение абсциссы не больше 16384");
        }
        if (y < -1024) {
            brokenInvariants.add("Значение ординаты не меньше -1024");
        }
        if (y > 1024) {
            brokenInvariants.add("Значение ординаты не больше 1024");
        }
        if (z < -16384) {
            brokenInvariants.add("Значение аппликаты не меньше -16384");
        }
        if (z > 16384) {
            brokenInvariants.add("Значение аппликаты не больше 16384");
        }
        if (!brokenInvariants.isEmpty()) {
            throw new ValidationException(
                ValidationException.createDetailedMessage(
                    "Нарушены инварианты бизнес-модели координат в трёхмерном пространстве",
                    brokenInvariants
                )
            );
        }

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    /**
     * Вычисление длины радиус-вектора относительно начала координат в
     * точке (0.0, 0.0, 0.0) по формуле sqrt(x^2 + y^2 + z^2).
     *
     * @author Расим "Buraki" Эминов
     * @return Длина радиус-вектора.
     * @since 0.1.0
     */
    public float getRadiusVectorLength() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;

        Coordinates otherCoordinates = (Coordinates) o;

        return x == otherCoordinates.x &&
               y == otherCoordinates.y &&
               z == otherCoordinates.z;
    }

    @Override
    public int compareTo(Coordinates o) {
        float firstRadiusVectorLength = getRadiusVectorLength();
        float secondRadiusVectorLength = o.getRadiusVectorLength();

        return Float.compare(firstRadiusVectorLength, secondRadiusVectorLength);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(\n" +
               ("x=" + x + ",").indent(4) +
               ("y=" + y + ",").indent(4) +
               ("z=" + z).indent(4) +
               ")";
    }
}
