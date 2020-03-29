package DAO;

import java.util.Collection;
import java.util.Optional;

public interface ElementDAO<E> {
    void add(E e);
    void update(E e);
    E get(int eID);
    //E get(long eID);
    Collection<E> getAll();
    void delete(E e);
}
