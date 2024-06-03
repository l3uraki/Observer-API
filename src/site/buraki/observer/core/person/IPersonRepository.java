package site.buraki.observer.core.person;

import site.buraki.observer.common.exceptions.core.DataIntegrityException;

import java.util.List;
import java.util.Optional;

/**
 * Абстрактное хранилище экземпляров бизнес-модели человека.
 *
 * @author Расим "Buraki" Эминов
 * @see Person
 * @since 0.1.0
 */
public interface IPersonRepository {

    /**
     * Добавление экземпляра бизнес-модели человека в хранилище.
     *
     * @author Расим "Buraki" Эминов
     * @param newPerson Добавляемый экземпляр бизнес-модели человека.
     * @throws DataIntegrityException Добавляемый экземпляр
     *     бизнес-модели человека уже содержится в хранилище.
     * @see Person
     * @since 0.1.0
     */
    void add(Person newPerson) throws DataIntegrityException;

    /**
     * Получение экземпляра бизнес-модели человека из хранилища по его
     * уникальному идентификатору.
     *
     * @author Расим "Buraki" Эминов
     * @param id Уникальный идентификатор.
     * @return Экземпляр бизнес-модели человека, если он содержится в
     *     хранилище.
     * @see Person
     * @since 0.1.0
     */
    Optional<Person> getByID(long id);

    /**
     * Получение всех экземпляров бизнес-модели человека из хранилища.
     *
     * @author Расим "Buraki" Эминов
     * @return Экземпляры бизнес-модели человека.
     * @see Person
     * @since 0.1.0
     */
    List<Person> getAll();

    /**
     * Получение количества экземпляров бизнес-модели человека в
     * хранилище.
     *
     * @author Расим "Buraki" Эминов
     * @return Количество экземпляров бизнес-модели человека.
     * @see Person
     * @since 0.1.0
     */
    int getSize();

    /**
     * Обновление экземпляра бизнес-модели человека в хранилище.
     *
     * @author Расим "Buraki" Эминов
     * @param newPerson Экземпляр-заменитель бизнес-модели человека.
     * @throws DataIntegrityException Обновляемый экземпляр
     *     бизнес-модели человека не содержится в хранилище.
     * @see Person
     * @since 0.1.0
     */
    void update(Person newPerson) throws DataIntegrityException;

    /**
     * Удаление экземпляра бизнес-модели человека из хранилища по его
     * уникальному идентификатору.
     *
     * @author Расим "Buraki" Эминов
     * @param id Уникальный идентификатор.
     * @throws DataIntegrityException Удаляемый экземпляр бизнес-модели
     *     человека не содержится в хранилище.
     * @see Person
     * @since 0.1.0
     */
    void removeByID(long id) throws DataIntegrityException;

    /**
     * Удаление всех экземпляров бизнес-модели человека из хранилища.
     *
     * @author Расим "Buraki" Эминов
     * @see Person
     * @since 0.1.0
     */
    void removeAll();
}
