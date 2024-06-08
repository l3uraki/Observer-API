package site.buraki.observer.infrastructure.marshalling.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import site.buraki.observer.infrastructure.marshalling.IDeserializer;
import site.buraki.observer.infrastructure.marshalling.json.adapters.LocalDateTimeAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Десериализатор языка разметки JSON.
 *
 * @author Расим "Buraki" Эминов
 * @param <T> Тип десериализуемого объекта.
 * @see IDeserializer
 * @since 0.3.0
 */
class Deserializer<T> implements IDeserializer<T> {

    private final Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .serializeNulls()
        .setPrettyPrinting()
        .create();

    @Override
    public T deserializeOne(Class<T> objectType, InputStream inputStream) {
        try (
            InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream,
                StandardCharsets.UTF_8
            )
        ) {
            return gson.fromJson(
                inputStreamReader,
                objectType
            );
        }
        catch (IOException e) {
            System.err.println("Ошибка десериализации объекта: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<T> deserializeMany(Class<T> objectsType, InputStream inputStream) {
        try (
            InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream,
                StandardCharsets.UTF_8
            )
        ) {
            return gson.fromJson(
                inputStreamReader,
                TypeToken.getParameterized(ArrayList.class, objectsType).getType()
            );
        }
        catch (IOException e) {
            System.err.println("Ошибка десериализации объектов: " + e.getMessage());
            return null;
        }
    }
}
