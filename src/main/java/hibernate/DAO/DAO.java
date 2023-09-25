package hibernate.DAO;

import java.util.List;
import java.util.UUID;

public interface DAO <T>{
    void save(Object obj);

    T getById(UUID id);

    List<T> getAll();

    void update(Object obj);

    void deleteById(UUID id);
}
