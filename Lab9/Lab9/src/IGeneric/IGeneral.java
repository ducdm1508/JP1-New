package IGeneric;

import java.util.List;

public interface IGeneral <T>{
    List<T> update(T obj);
    List<T> sort();
    T getById(int id);
    List<T> getByName(String keyword);
}
