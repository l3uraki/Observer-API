package site.buraki.observer.infrastructure.marshalling.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import site.buraki.observer.infrastructure.marshalling.ISerializer;
import site.buraki.observer.infrastructure.marshalling.json.adapters.LocalDateTimeAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Сериализатор языка разметки JSON.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип сериализуемого объекта.
 * @see ISerializer
 * @see JSONMarshallingManager
 * @since 0.3.0
 */
class Serializer<T> implements ISerializer<T> {

    private final Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .serializeNulls()
        .setPrettyPrinting()
        .create();

    @Override
    public void serializeOne(T object, OutputStream outputStream) {
        try (
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                outputStream,
                StandardCharsets.UTF_8
            )
        ) {
            gson.toJson(object, outputStreamWriter);
        }
        catch (IOException e) {
            System.err.println("Ошибка сериализации объекта: " + e.getMessage());
        }
    }

    @Override
    public void serializeMany(List<T> objects, OutputStream outputStream) {
        try (
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                outputStream,
                StandardCharsets.UTF_8
            )
        ) {
            gson.toJson(objects, outputStreamWriter);
        }
        catch (IOException e) {
            System.err.println("Ошибка сериализации объектов: " + e.getMessage());
        }
    }
}
