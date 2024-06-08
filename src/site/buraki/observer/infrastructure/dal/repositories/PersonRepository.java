package site.buraki.observer.infrastructure.dal.repositories;

import site.buraki.observer.common.exceptions.core.DataIntegrityException;
import site.buraki.observer.core.person.IPersonRepository;
import site.buraki.observer.core.person.Person;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

/**
 * Хранилище экземпляров бизнес-модели человека, основанное на
 * коллекции LinkedHashSet.
 *
 * @author Расим "Buraki" Эминов
 * @see IPersonRepository
 * @since 0.4.0
 */
class PersonRepository implements IPersonRepository {

    private final LinkedHashSet<Person> innerCollection = new LinkedHashSet<>();

    @Override
    public void add(Person newPerson) throws DataIntegrityException {
        if (!innerCollection.add(newPerson)) {
            throw new DataIntegrityException(
                "Добавляемый экземпляр бизнес-модели человека уже содержится в хранилище"
            );
        }
    }

    @Override
    public Optional<Person> getByID(long id) {
        return innerCollection.stream()
            .filter(person -> person.getID() == id)
            .findFirst();
    }

    @Override
    public List<Person> getAll() {
        return innerCollection.stream()
            .toList();
    }

    @Override
    public int getSize() {
        return innerCollection.size();
    }

    @Override
    public void update(Person newPerson) throws DataIntegrityException {
        Optional<Person> existingPerson = getByID(newPerson.getID());

        if (existingPerson.isEmpty()) {
            throw new DataIntegrityException(
                "Обновляемый экземпляр бизнес-модели человека не содержится в хранилище"
            );
        }

        innerCollection.remove(existingPerson.get());
        innerCollection.add(newPerson);
    }

    @Override
    public void removeByID(long id) throws DataIntegrityException {
        Optional<Person> existingPerson = getByID(id);

        if (existingPerson.isEmpty()) {
            throw new DataIntegrityException(
                "Удаляемый экземпляр бизнес-модели человека не содержится в хранилище"
            );
        }

        innerCollection.remove(existingPerson.get());
    }

    @Override
    public void removeAll() {
        innerCollection.clear();
    }
}
