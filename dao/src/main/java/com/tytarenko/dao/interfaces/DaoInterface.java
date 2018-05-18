package com.tytarenko.dao.interfaces;

import java.util.List;

public interface DaoInterface<T> {

    List<T> get(String passport);
    List<T> getByReception(long id);
    void add(T object);

}
