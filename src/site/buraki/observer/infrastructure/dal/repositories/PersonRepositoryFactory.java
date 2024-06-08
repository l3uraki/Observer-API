package site.buraki.observer.infrastructure.dal.repositories;

import site.buraki.observer.common.exceptions.core.DataIntegrityException;
import site.buraki.observer.core.person.IPersonRepository;
import site.buraki.observer.core.person.Person;
import site.buraki.observer.infrastructure.marshalling.IDeserializer;
import site.buraki.observer.infrastructure.marshalling.MarshallingManagerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Фабрика хранилищ экземпляров бизнес-модели человека.
 *
 * @author Расим "Buraki" Эминов
 * @see PersonRepository
 * @since 0.4.0
 */
public class PersonRepositoryFactory {

    private static final IPersonRepository personRepository = new PersonRepository();

    static {
        Path saveFilepath = Path.of(System.getenv("SAVE_FILEPATH"));
        IDeserializer<Person> deserializer = MarshallingManagerFactory
            .<Person>getJSONMarshallingManager()
            .getDeserializer();

        try (
            FileInputStream fileInputStream = new FileInputStream(saveFilepath.toFile());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)
        ) {
            List<Person> people = deserializer.deserializeMany(Person.class, bufferedInputStream);

            if (people != null) {
                for (Person person : people) {
                    try {
                        personRepository.add(person);
                    }
                    catch (DataIntegrityException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
        catch (IOException e) {
            throw new AssertionError("Application is not setup");
        }
    }

    public static IPersonRepository getPersonRepository() {
        return personRepository;
    }
}
